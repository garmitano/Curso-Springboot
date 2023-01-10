package es.edu.escuelait.bautismospring.dao;

import es.edu.escuelait.bautismospring.models.Equipo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EquipoDaoImp implements EquipoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Equipo> listarTodos() {
        String query="FROM Equipo";
        return entityManager.createQuery(query).getResultList();
    }
}
