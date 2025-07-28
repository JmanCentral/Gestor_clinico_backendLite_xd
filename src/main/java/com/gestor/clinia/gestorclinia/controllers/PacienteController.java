package com.gestor.clinia.gestorclinia.controllers;

import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaResponseDTO;
import com.gestor.clinia.gestorclinia.dtos.PacienteDTO;
import com.gestor.clinia.gestorclinia.servicies.consultaMedica.IConsultaMedicaService;
import com.gestor.clinia.gestorclinia.servicies.paciente.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/api/pacientes")
@CrossOrigin("*")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IConsultaMedicaService consultaMedicaService;


    @MutationMapping
    public String crearPaciente(@Argument PacienteDTO dto){
        pacienteService.crearPaciente(dto);
        return "Paciente creado";
    }

    @QueryMapping
    public PacienteDTO buscarPaciente(@Argument Long id){
        return pacienteService.obtenerPacientePorId(id);
    }

    @QueryMapping
    public List<PacienteDTO> findAll() {
        return pacienteService.listarPacientes();
    }


    @MutationMapping
    public String updatePaciente(@Argument Long id, @Argument PacienteDTO dto)   {
        pacienteService.actualizarPaciente(id, dto);
        return "Paciente actualizado";
    }

    @MutationMapping
    public String deletePaciente(@Argument Long id){
        pacienteService.eliminarPaciente(id);
        return "Paciente eliminado";
    }

    @SchemaMapping(typeName = "Paciente", field = "consultasMedicas")
    public List<ConsultaMedicaResponseDTO> resolverConsultasMedicas(PacienteDTO dto) {
        return consultaMedicaService.listarConsultasPorPaciente(dto.getId());
    }

}
