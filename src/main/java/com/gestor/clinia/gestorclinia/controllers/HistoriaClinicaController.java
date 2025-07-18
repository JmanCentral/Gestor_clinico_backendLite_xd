package com.gestor.clinia.gestorclinia.controllers;

import com.gestor.clinia.gestorclinia.dtos.HistoriaClinicaDTO;
import com.gestor.clinia.gestorclinia.servicies.historiaClinica.IHistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/historia")
@CrossOrigin("*")
public class HistoriaClinicaController {

    @Autowired
    private IHistoriaClinicaService historiaClinicaService;

    @PostMapping("/register")
    public ResponseEntity<Void> crearHistoria(@RequestBody HistoriaClinicaDTO dto){
        historiaClinicaService.guardar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getIdPaciente/{idPaciente}")
    public ResponseEntity<HistoriaClinicaDTO> getIdPaciente(@PathVariable("idPaciente") Long idPaciente){
        HistoriaClinicaDTO historiaClinica = historiaClinicaService.listarPorPaciente(idPaciente);

        if (historiaClinica == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(historiaClinica);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<HistoriaClinicaDTO> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(historiaClinicaService.buscar(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody HistoriaClinicaDTO dto){
        historiaClinicaService.actualizar(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id){
        historiaClinicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
