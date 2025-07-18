package com.gestor.clinia.gestorclinia.servicies.usuario;

import com.gestor.clinia.gestorclinia.dtos.UserDTO;
import com.gestor.clinia.gestorclinia.entities.Rol;
import com.gestor.clinia.gestorclinia.entities.User;
import com.gestor.clinia.gestorclinia.entities.enums.ERole;
import com.gestor.clinia.gestorclinia.exceptions.EmailAlreadyRegisteredException;
import com.gestor.clinia.gestorclinia.exceptions.RolNotFoundException;
import com.gestor.clinia.gestorclinia.exceptions.UsernameAlreadyRegisteredException;
import com.gestor.clinia.gestorclinia.mappers.UserMapper;
import com.gestor.clinia.gestorclinia.persistencie.rol.RolRepository;
import com.gestor.clinia.gestorclinia.persistencie.usuario.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class IUserServiceImpl  implements IUserService{

    private final UserRepository userRepository;
    private final RolRepository rolRepository;
    private final UserMapper userMapper;

@Override
public void save(UserDTO userRequestDTO) {

    if (userRepository.existsByUsername(userRequestDTO.getUsername())) {
        throw new UsernameAlreadyRegisteredException("El username ya está registrado.");
    }

    if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
        throw new EmailAlreadyRegisteredException("El correo ya está registrado.");
    }

    User user = userMapper.toEntity(userRequestDTO);

    Set<Rol> roles = userRequestDTO.getRol().stream()
            .map(rol -> {

                log.info("Rol recibido como string: {}", rol);

                ERole rolEnum;
                try {
                    rolEnum = ERole.valueOf(rol);
                } catch (IllegalArgumentException e) {
                    log.error("Rol inválido: {}. No corresponde a ningún valor del enum ERole.", rol);
                    throw new RolNotFoundException("Rol inválido: " + rol);
                }

                Rol rolEntity = rolRepository.findByName(rolEnum)
                        .orElseThrow(() -> {
                            log.error("Rol no encontrado en base de datos: {}", rolEnum);
                            return new RolNotFoundException("Rol no encontrado: " + rolEnum);
                        });

                log.info("Rol encontrado en DB: {}", rolEntity.getName());
                return rolEntity;
            })
            .collect(Collectors.toSet());

    user.setRol(roles);
    userRepository.save(user); // Guardado sin necesidad de devolver el resultado
}
}
