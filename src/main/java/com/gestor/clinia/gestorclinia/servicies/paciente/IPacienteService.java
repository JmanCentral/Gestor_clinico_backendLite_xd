package com.gestor.clinia.gestorclinia.servicies.paciente;

import com.gestor.clinia.gestorclinia.dtos.PacienteDTO;

import java.util.List;

public interface IPacienteService {

    String crearPaciente(PacienteDTO dto);
    String actualizarPaciente(Long id , PacienteDTO dto);
    void eliminarPaciente(Long id);
    PacienteDTO obtenerPacientePorId(Long id);
    List<PacienteDTO> buscarPorNombre(String nombre);
    List<PacienteDTO> listarPacientes();

}
