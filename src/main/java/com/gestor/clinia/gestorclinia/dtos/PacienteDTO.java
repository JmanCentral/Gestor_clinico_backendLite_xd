package com.gestor.clinia.gestorclinia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String documento;
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String direccionCompleta;
    private String tipoSangre;
}
