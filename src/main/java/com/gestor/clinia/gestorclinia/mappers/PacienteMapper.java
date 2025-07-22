package com.gestor.clinia.gestorclinia.mappers;


import com.gestor.clinia.gestorclinia.dtos.PacienteDTO;
import com.gestor.clinia.gestorclinia.entities.Paciente;

public class PacienteMapper {

    public static Paciente dtoToEntity(PacienteDTO dto) {
       return Paciente.builder()
               .nombre(dto.getNombre())
               .documento(dto.getDocumento())
               .correo(dto.getCorreo())
               .telefono(dto.getTelefono())
               .fechaNacimiento(dto.getFechaNacimiento())
               .direccionCompleta(dto.getDireccionCompleta())
               .tipoSangre(dto.getTipoSangre()).build();
    }

    public static PacienteDTO entityToDTO(Paciente paciente) {

        return PacienteDTO.builder()
                .id(paciente.getId())
                .nombre(paciente.getNombre())
                .documento(paciente.getDocumento())
                .correo(paciente.getCorreo())
                .telefono(paciente.getTelefono())
                .fechaNacimiento(paciente.getFechaNacimiento())
                .direccionCompleta(paciente.getDireccionCompleta())
                .tipoSangre(paciente.getTipoSangre())
                .build();
    }

    public static void actualizarEntityDesdeDTO(Paciente paciente, PacienteDTO dto) {

        if (dto.getNombre() != null) paciente.setNombre(dto.getNombre());
        if (dto.getDocumento() != null) paciente.setDocumento(dto.getDocumento());
        if (dto.getCorreo() != null) paciente.setCorreo(dto.getCorreo());
        if (dto.getTelefono() != null) paciente.setTelefono(dto.getTelefono());
        if (dto.getFechaNacimiento() != null) paciente.setFechaNacimiento(dto.getFechaNacimiento());
        if (dto.getDireccionCompleta() != null) paciente.setDireccionCompleta(dto.getDireccionCompleta());
        if (dto.getTipoSangre() != null) paciente.setTipoSangre(dto.getTipoSangre());

    }

}