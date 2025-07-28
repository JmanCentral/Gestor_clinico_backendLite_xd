package com.gestor.clinia.gestorclinia.controllers;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaRequestDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaResponseDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaUpdateRequestDTO;
import com.gestor.clinia.gestorclinia.servicies.consultaMedica.IConsultaMedicaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ConsultaMedicaController {

    private final IConsultaMedicaServiceImpl consultaMedicaService;

    @MutationMapping
    public String crearConsulta(@Argument ConsultaMedicaRequestDTO dto) {
        consultaMedicaService.crearConsulta(dto);
        return "Consulta creada";
    }

    @QueryMapping
    public ConsultaMedicaResponseDTO consultaMedica(@Argument Long id) {
        return consultaMedicaService.obtenerConsultaPorId(id);
    }

    @QueryMapping
    public List<ConsultaMedicaResponseDTO> consultaMedicaByPaciente(@Argument Long id){
        return consultaMedicaService.listarConsultasPorPaciente(id);
    }

    @MutationMapping
    public String updateConsulta(@Argument Long id , @Argument ConsultaMedicaUpdateRequestDTO dto) {
        consultaMedicaService.actualizarConsulta(id, dto);
        return "Consulta actualizada";
    }

    @MutationMapping
    public String deleteConsulta(@Argument Long id){
        consultaMedicaService.eliminarConsulta(id);
        return "Consulta eliminada";
    }

}
