package com.gestor.clinia.gestorclinia.controllers;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaRequestDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaResponseDTO;
import com.gestor.clinia.gestorclinia.dtos.ConsultaMedicaDTO.ConsultaMedicaUpdateRequestDTO;
import com.gestor.clinia.gestorclinia.servicies.consultaMedica.IConsultaMedicaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaMedicaController {

    private final IConsultaMedicaServiceImpl consultaMedicaService;

    @PostMapping
    public ResponseEntity<String> crearConsulta(@RequestBody ConsultaMedicaRequestDTO dto) {
        consultaMedicaService.crearConsulta(dto);
        return ResponseEntity.ok("Consulta creada");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaMedicaResponseDTO> consultaMedica(@PathVariable Long id) {
        return ResponseEntity.ok(consultaMedicaService.obtenerConsultaPorId(id));
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<ConsultaMedicaResponseDTO>> consultaMedicaByPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(consultaMedicaService.listarConsultasPorPaciente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateConsulta(@PathVariable Long id, @RequestBody ConsultaMedicaUpdateRequestDTO dto) {
        consultaMedicaService.actualizarConsulta(id, dto);
        return ResponseEntity.ok("Consulta actualizada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConsulta(@PathVariable Long id) {
        consultaMedicaService.eliminarConsulta(id);
        return ResponseEntity.ok("Consulta eliminada");
    }
}
