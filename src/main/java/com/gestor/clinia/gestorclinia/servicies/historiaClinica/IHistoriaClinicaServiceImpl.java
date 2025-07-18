package com.gestor.clinia.gestorclinia.servicies.historiaClinica;
import com.gestor.clinia.gestorclinia.dtos.HistoriaClinicaDTO;
import com.gestor.clinia.gestorclinia.entities.HistoriaClinica;
import com.gestor.clinia.gestorclinia.entities.Paciente;
import com.gestor.clinia.gestorclinia.mappers.HistoriaClinicaMapper;
import com.gestor.clinia.gestorclinia.persistencie.historiaClinica.HistoriaClinicaDAO;
import com.gestor.clinia.gestorclinia.persistencie.paciente.PacienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.gestor.clinia.gestorclinia.mappers.HistoriaClinicaMapper.dtoToEntity;
import static com.gestor.clinia.gestorclinia.mappers.HistoriaClinicaMapper.entityToDTO;


@Service
public class IHistoriaClinicaServiceImpl implements IHistoriaClinicaService {

    @Autowired
    private HistoriaClinicaDAO historiaClinicaDAO;
    @Autowired
    private PacienteDAO pacienteDAO;

    @Override
    public void guardar(HistoriaClinicaDTO dto) {

        HistoriaClinica historiaClinica = dtoToEntity(dto);

        Paciente paciente = pacienteDAO.buscarPorId(dto.getIdPaciente());

        if (paciente == null) {
            throw new IllegalArgumentException("No se encontró el paciente con ID: " + dto.getIdPaciente());
        }

        historiaClinica.setPaciente(paciente);
        paciente.setHistoriaClinica(historiaClinica);

        historiaClinicaDAO.guardar(historiaClinica);
    }


    @Override
    public void actualizar(Long id, HistoriaClinicaDTO dto) {

        HistoriaClinica existente = historiaClinicaDAO.buscarPorId(id);

        if (existente == null) {
            throw new IllegalArgumentException("No existe la historia");
        }

        HistoriaClinicaMapper.actualizarEntityDesdeDTO(existente, dto);
        historiaClinicaDAO.actualizar(existente);
    }

    @Override
    public HistoriaClinicaDTO buscar(Long id) {

        HistoriaClinica historiaClinica = historiaClinicaDAO.buscarPorId(id);
        return historiaClinica != null ? entityToDTO(historiaClinica) : null;
    }


    @Override
    public void eliminar(Long id) {
        HistoriaClinica historiaClinica = historiaClinicaDAO.buscarPorId(id);

        if (historiaClinica != null) {
            Paciente paciente = historiaClinica.getPaciente();

            if (paciente != null) {
                paciente.setHistoriaClinica(null);
            }

            historiaClinicaDAO.eliminar(historiaClinica);
        } else {
            System.out.println("⚠️ No se encontró historia clínica con ID: " + id + " para eliminar.");
        }
    }



    @Override
    public HistoriaClinicaDTO listarPorPaciente(Long idPaciente) {

        HistoriaClinica historiaClinica = historiaClinicaDAO.listarPorPaciente(idPaciente);
        return historiaClinica != null ? entityToDTO(historiaClinica) : null;

    }

}
