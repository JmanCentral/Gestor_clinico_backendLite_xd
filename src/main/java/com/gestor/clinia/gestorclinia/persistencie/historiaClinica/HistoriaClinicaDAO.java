package com.gestor.clinia.gestorclinia.persistencie.historiaClinica;

import com.gestor.clinia.gestorclinia.entities.HistoriaClinica;

public interface HistoriaClinicaDAO {

    void guardar (HistoriaClinica historiaClinica);
    void actualizar (HistoriaClinica historiaClinica);
    void eliminar (HistoriaClinica historiaClinica);
    HistoriaClinica buscarPorId (Long id);
    HistoriaClinica listarPorPaciente(Long idPaciente);

}
