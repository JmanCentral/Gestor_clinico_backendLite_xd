package com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO;

import java.time.LocalDate;
import java.time.LocalTime;

import com.gestor.clinia.gestorclinia.entities.enums.TipoNotificacion;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConsultaMedicaUpdateRequestDTO {

    private LocalDate fechaConsulta;
    private LocalTime horaConsulta;
    private String motivo;
    private String diagnostico;
    private TipoNotificacion tipoNotificacion;
    private Long idPaciente;

}
