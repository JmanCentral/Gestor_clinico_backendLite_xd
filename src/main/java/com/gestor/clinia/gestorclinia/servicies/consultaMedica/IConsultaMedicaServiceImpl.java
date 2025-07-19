package com.gestor.clinia.gestorclinia.servicies.consultaMedica;

import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaRequestDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaResponseDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaUpdateRequestDTO;
import com.gestor.clinia.gestorclinia.entities.ConsultaMedica;
import com.gestor.clinia.gestorclinia.entities.Paciente;
import com.gestor.clinia.gestorclinia.mappers.ConsultaMedicaMapper;
import com.gestor.clinia.gestorclinia.persistencie.consultaMedica.ConsultaMedicaRepository;
import com.gestor.clinia.gestorclinia.persistencie.paciente.PacienteDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IConsultaMedicaServiceImpl implements IConsultaMedicaService{

    private final ConsultaMedicaRepository consultaMedicaRepository;
    private final PacienteDAO pacienteDAO;
    private final ConsultaMedicaMapper consultaMedicaMapper;

    @Override
    public String crearConsulta(ConsultaMedicaRequestDTO dto) {

        ConsultaMedica consulta = consultaMedicaMapper.toEntity(dto);
        Paciente paciente = pacienteDAO.buscarPorId(dto.getIdPaciente());
        if (paciente == null) {
            throw new RuntimeException("Paciente no encontrado");
        }
        consulta.setPaciente(paciente);
        consultaMedicaRepository.save(consulta);

        return "Consulta creada con ID: " + consulta.getId();
    }

    @Override
    public ConsultaMedicaResponseDTO obtenerConsultaPorId(Long id) {
        ConsultaMedica consulta = consultaMedicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));
        return consultaMedicaMapper.toDTO(consulta);
    }

    @Override
    public String actualizarConsulta(Long id, ConsultaMedicaUpdateRequestDTO dto) {

        ConsultaMedica consulta = consultaMedicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));

        consultaMedicaMapper.updateEntityFromDto(dto , consulta);
        consultaMedicaRepository.save(consulta);

        log.info("Consulta actualizada: {}", dto);

        return "Consulta actualizada con ID: " + consulta.getId();

    }

    @Override
    public String eliminarConsulta(Long id) {

        ConsultaMedica consulta = consultaMedicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));

        consultaMedicaRepository.delete(consulta);
        return "Consulta eliminada con ID: " + consulta.getId();

    }

    @Override
    public List<ConsultaMedicaResponseDTO> listarConsultas() {

        List<ConsultaMedica> consultas = consultaMedicaRepository.findAll();
        return consultas.stream()
                .map(consultaMedicaMapper::toDTO)
                .toList();
    }

    @Override
    public List<ConsultaMedicaResponseDTO> listarConsultasPorPaciente(Long pacienteId) {
        Paciente paciente = pacienteDAO.buscarPorId(pacienteId);
        if (paciente == null) {
            throw new RuntimeException("Paciente no encontrado");
        }
        List<ConsultaMedica> consultas = consultaMedicaRepository.findByPaciente_Id(pacienteId);
        return consultas.stream()
                .map(consultaMedicaMapper::toDTO)
                .toList();
    }
}
