package com.gestor.clinia.gestorclinia.servicies.paciente;
import com.gestor.clinia.gestorclinia.dtos.PacienteDTO;
import com.gestor.clinia.gestorclinia.entities.Paciente;
import com.gestor.clinia.gestorclinia.mappers.PacienteMapper;
import com.gestor.clinia.gestorclinia.persistencie.paciente.PacienteDAO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.gestor.clinia.gestorclinia.mappers.PacienteMapper.*;

@Service
public class IPacienteServiceImpl implements IPacienteService{

    @Autowired
    private PacienteDAO  pacienteDAO;

    @Override
    public String crearPaciente(PacienteDTO dto) {
        Paciente paciente = dtoToEntity(dto);
        pacienteDAO.guardar(paciente);
        return "Paciente creado con éxito";
    }

    @Override
    public String actualizarPaciente(Long id  , PacienteDTO dto) {

        Paciente existePaciente = pacienteDAO.buscarPorId(id);

        if (existePaciente != null) {
            actualizarEntityDesdeDTO(existePaciente, dto);
            pacienteDAO.actualizar(existePaciente);
        } else {
            throw new EntityNotFoundException("Paciente con id " + id + " no encontrado.");
        }

        return "Paciente modificado con exito";

    }

    @Override
    public void eliminarPaciente(Long id) {
        Paciente paciente = pacienteDAO.buscarPorId(id);
        if (paciente != null) {
            pacienteDAO.eliminar(paciente);
        }
    }

    @Override
    public PacienteDTO obtenerPacientePorId(Long id) {
        Paciente paciente = pacienteDAO.buscarPorId(id);
        return paciente != null ? entityToDTO(paciente) : null;
    }

    @Override
    public List<PacienteDTO> buscarPorNombre(String nombre) {
        List<Paciente> pacientes = pacienteDAO.buscarPorNombre(nombre);
        return pacientes.stream().map(PacienteMapper::entityToDTO).toList();
    }

    @Override
    public List<PacienteDTO> listarPacientes() {

        List<Paciente> pacientes = pacienteDAO.listarTodos();

        return pacientes.stream()
                .map(PacienteMapper::entityToDTO)
                .toList();
    }
}
