package com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO;

import com.gestor.clinia.gestorclinia.entities.enums.TipoNotificacion;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaMedicaRequestDTO {

    private LocalDate fechaConsulta;
    private LocalTime horaConsulta;
    private String motivo;
    private String diagnostico;
    private TipoNotificacion tipoNotificacion;
    private Long idPaciente;
}
