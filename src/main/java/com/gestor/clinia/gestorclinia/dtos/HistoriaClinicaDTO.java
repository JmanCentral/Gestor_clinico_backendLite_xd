package com.gestor.clinia.gestorclinia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoriaClinicaDTO {
    private Long id;
    private String alergias;
    private String enfermedadesPrevias;
    private String observacionesGenerales;
    private LocalDate fechaCreacion;
    private String antecedentes;
    private Long idPaciente;
}
