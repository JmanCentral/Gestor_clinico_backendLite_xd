package com.gestor.clinia.gestorclinia.mappers;

import com.gestor.clinia.gestorclinia.dtos.UserDTO;
import com.gestor.clinia.gestorclinia.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class UserMapperImpl implements UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User toEntity(UserDTO dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();
    }
}
