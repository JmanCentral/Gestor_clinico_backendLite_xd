package com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO;

import lombok.*;

import java.util.List;

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
    private Long idPaciente;
}
