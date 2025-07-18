package com.gestor.clinia.gestorclinia.servicies.historiaClinica;


import com.gestor.clinia.gestorclinia.dtos.HistoriaClinicaDTO;

public interface IHistoriaClinicaService {

    void guardar (HistoriaClinicaDTO dto);
    void actualizar (Long id , HistoriaClinicaDTO dto);
    HistoriaClinicaDTO buscar (Long id);
    void eliminar (Long id);
    HistoriaClinicaDTO listarPorPaciente(Long idPaciente);
}
