package com.gestor.clinia.gestorclinia.persistencie.paciente;


import com.gestor.clinia.gestorclinia.entities.Paciente;

import java.util.List;

public interface PacienteDAO {

    void guardar(Paciente paciente);
    void actualizar(Paciente paciente);
    void eliminar(Paciente paciente);
    Paciente buscarPorId(Long id);
    List<Paciente> buscarPorNombre(String nombre);
    List<Paciente> listarTodos();
}
