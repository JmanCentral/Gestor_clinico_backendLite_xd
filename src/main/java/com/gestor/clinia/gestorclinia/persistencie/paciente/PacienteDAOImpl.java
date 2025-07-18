package com.gestor.clinia.gestorclinia.persistencie.paciente;

import com.gestor.clinia.gestorclinia.entities.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PacienteDAOImpl implements PacienteDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void guardar(Paciente paciente) {
        entityManager.persist(paciente);
    }


    @Override
    @Transactional
    public void actualizar(Paciente paciente) {
        entityManager.merge(paciente);
    }

    @Override
    @Transactional
    public void eliminar(Paciente paciente) {
        entityManager.remove(entityManager.contains(paciente) ? paciente : entityManager.merge(paciente));
    }

    @Override
    @Transactional
    public Paciente buscarPorId(Long id) {
        return entityManager.find(Paciente.class, id);
    }

    @Override
    @Transactional
    public List<Paciente> buscarPorNombre(String nombre) {

        String jpql = "SELECT p FROM Paciente p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))";
        return entityManager.createQuery(jpql, Paciente.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }


    @Override
    @Transactional
    public List<Paciente> listarTodos() {
        TypedQuery<Paciente> query = entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class);
        return query.getResultList();
    }
}
