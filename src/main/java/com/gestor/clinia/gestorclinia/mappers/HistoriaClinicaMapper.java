package com.gestor.clinia.gestorclinia.mappers;


import com.gestor.clinia.gestorclinia.dtos.HistoriaClinicaDTO;
import com.gestor.clinia.gestorclinia.entities.HistoriaClinica;
import com.gestor.clinia.gestorclinia.entities.Paciente;

import java.time.LocalDate;

public class HistoriaClinicaMapper {

    public static HistoriaClinica dtoToEntity(HistoriaClinicaDTO dto) {
        HistoriaClinica historiaClinica  = new HistoriaClinica();
        historiaClinica.setId(dto.getId());
        historiaClinica.setAlergias(dto.getAlergias());
        historiaClinica.setEnfermedadesPrevias(dto.getEnfermedadesPrevias());
        historiaClinica.setObservacionesGenerales(dto.getObservacionesGenerales());
        historiaClinica.setFechaCreacion(LocalDate.now());
        historiaClinica.setAntecedentes(dto.getAntecedentes());

        Paciente paciente = new Paciente();
        paciente.setId(dto.getIdPaciente());

        historiaClinica.setPaciente(paciente);
        return historiaClinica;
    }

    public static HistoriaClinicaDTO entityToDTO(HistoriaClinica historiaClinica) {

        HistoriaClinicaDTO dto = new HistoriaClinicaDTO();
        dto.setId(historiaClinica.getId());
        dto.setAlergias(historiaClinica.getAlergias());
        dto.setEnfermedadesPrevias(historiaClinica.getEnfermedadesPrevias());
        dto.setObservacionesGenerales(historiaClinica.getObservacionesGenerales());
        dto.setFechaCreacion(historiaClinica.getFechaCreacion());
        dto.setAntecedentes(historiaClinica.getAntecedentes());
        dto.setIdPaciente(historiaClinica.getPaciente().getId());

        return dto;

    }

    public static void actualizarEntityDesdeDTO(HistoriaClinica historiaClinica , HistoriaClinicaDTO dto) {

        historiaClinica.setAlergias(dto.getAlergias());
        historiaClinica.setEnfermedadesPrevias(dto.getEnfermedadesPrevias());
        historiaClinica.setObservacionesGenerales(dto.getObservacionesGenerales());
        historiaClinica.setFechaCreacion(LocalDate.now());
        historiaClinica.setAntecedentes(dto.getAntecedentes());

    }

}

