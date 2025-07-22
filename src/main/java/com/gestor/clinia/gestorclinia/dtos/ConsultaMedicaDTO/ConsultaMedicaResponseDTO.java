package com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO;

import com.gestor.clinia.gestorclinia.entities.enums.TipoNotificacion;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaMedicaResponseDTO {
    private Long id;
    private String fechaConsulta;
    private String horaConsulta;
    private String motivo;
    private String diagnostico;
    private TipoNotificacion tipoNotificacion;
    private Long idPaciente;
}
