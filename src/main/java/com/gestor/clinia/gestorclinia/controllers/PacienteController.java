package com.gestor.clinia.gestorclinia.controllers;

import com.gestor.clinia.gestorclinia.dtos.PacienteDTO;
import com.gestor.clinia.gestorclinia.servicies.paciente.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin("*")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping("/register")
    public ResponseEntity<Void> crearPaciente(@RequestBody PacienteDTO dto) {
        pacienteService.crearPaciente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.obtenerPacientePorId(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PacienteDTO>> findAll() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<PacienteDTO>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(pacienteService.buscarPorNombre(name));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updatePaciente(@PathVariable Long id, @RequestBody PacienteDTO dto) {
        pacienteService.actualizarPaciente(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }

}
