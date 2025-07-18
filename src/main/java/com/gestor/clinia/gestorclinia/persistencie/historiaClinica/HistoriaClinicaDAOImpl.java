package com.gestor.clinia.gestorclinia.persistencie.historiaClinica;
import com.gestor.clinia.gestorclinia.entities.HistoriaClinica;
import com.gestor.clinia.gestorclinia.entities.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HistoriaClinicaDAOImpl implements HistoriaClinicaDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void guardar(HistoriaClinica historiaClinica) {

        entityManager.persist(historiaClinica);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void actualizar(HistoriaClinica historiaClinica) {

        entityManager.merge(historiaClinica);
    }

    @Override
    @Transactional
    public void eliminar(HistoriaClinica historiaClinica) {
        System.out.println(historiaClinica);
        entityManager.remove(entityManager.contains(historiaClinica) ? historiaClinica : entityManager.merge(historiaClinica));
    }
    
    @Override
    @Transactional
    public HistoriaClinica buscarPorId(Long id) {
        return entityManager.find(HistoriaClinica.class, id);
    }

    @Override
    @Transactional
    public HistoriaClinica listarPorPaciente(Long idPaciente) {
        Paciente paciente = entityManager.find(Paciente.class, idPaciente);
        return paciente.getHistoriaClinica();
    }
}
