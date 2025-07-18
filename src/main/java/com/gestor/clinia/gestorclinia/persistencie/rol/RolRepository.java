package com.gestor.clinia.gestorclinia.persistencie.rol;

import com.gestor.clinia.gestorclinia.entities.Rol;
import com.gestor.clinia.gestorclinia.entities.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByName(ERole name);

}
