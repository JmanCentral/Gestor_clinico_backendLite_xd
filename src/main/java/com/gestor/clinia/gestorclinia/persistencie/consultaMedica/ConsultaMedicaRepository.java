package com.gestor.clinia.gestorclinia.persistencie.consultaMedica;


import com.gestor.clinia.gestorclinia.entities.ConsultaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaMedicaRepository extends JpaRepository<ConsultaMedica, Long> {

    Optional<ConsultaMedica> findById(Long id);

    List<ConsultaMedica> findByPaciente_Id(Long idPaciente);

}
