package com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO;

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
    private Long idPaciente;
}
