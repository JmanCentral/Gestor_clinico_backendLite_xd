package com.gestor.clinia.gestorclinia.servicies.consultaMedica;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaRequestDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaResponseDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaUpdateRequestDTO;

import java.util.List;


public interface IConsultaMedicaService {

    String crearConsulta(ConsultaMedicaRequestDTO dto);
    ConsultaMedicaResponseDTO obtenerConsultaPorId(Long id);
    String actualizarConsulta(Long id, ConsultaMedicaUpdateRequestDTO dto);
    String eliminarConsulta(Long id);
    List<ConsultaMedicaResponseDTO> listarConsultas();
    List<ConsultaMedicaResponseDTO> listarConsultasPorPaciente(Long pacienteId);
}
