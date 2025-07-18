package com.gestor.clinia.gestorclinia.mappers;


import com.gestor.clinia.gestorclinia.dtos.PacienteDTO;
import com.gestor.clinia.gestorclinia.entities.Paciente;

public class PacienteMapper {

    public static Paciente dtoToEntity(PacienteDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setId(dto.getId());
        paciente.setNombre(dto.getNombre());
        paciente.setDocumento(dto.getDocumento());
        paciente.setCorreo(dto.getCorreo());
        paciente.setTelefono(dto.getTelefono());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setDireccionCompleta(dto.getDireccionCompleta());
        paciente.setTipoSangre(dto.getTipoSangre());
        return paciente;
    }

    public static PacienteDTO entityToDTO(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setId(paciente.getId());
        dto.setNombre(paciente.getNombre());
        dto.setDocumento(paciente.getDocumento());
        dto.setCorreo(paciente.getCorreo());
        dto.setTelefono(paciente.getTelefono());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());
        dto.setDireccionCompleta(paciente.getDireccionCompleta());
        dto.setTipoSangre(paciente.getTipoSangre());
        return dto;
    }

    public static void actualizarEntityDesdeDTO(Paciente paciente, PacienteDTO dto) {

        paciente.setNombre(dto.getNombre());
        paciente.setDocumento(dto.getDocumento());
        paciente.setCorreo(dto.getCorreo());
        paciente.setTelefono(dto.getTelefono());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setDireccionCompleta(dto.getDireccionCompleta());
        paciente.setTipoSangre(dto.getTipoSangre());
    }


}