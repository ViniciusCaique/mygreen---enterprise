package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.models.ClimaAdequado;

public class ClimaAdequadoRepository {

    private EntityManager entityManager;

    public ClimaAdequadoRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public Iterable<ClimaAdequado> findAll() {
        var jpql = "SELECT ca FROM T_G_CLIMA_ADEQUADO ca";
        var query = entityManager.createQuery(jpql, ClimaAdequado.class);
        var climasAde = query.getResultList();
        return climasAde;
    }

    public ClimaAdequado findById(Long id) {
        var jpql = "SELECT ca FROM T_G_CLIMA_ADEQUADO ca where id = :id";
        var query = entityManager.createQuery(jpql, ClimaAdequado.class);
        query.setParameter("id", id);
        var climaAde = query.getSingleResult();
        return climaAde;
    }

    public void createClimaAdequado(ClimaAdequado climaAdequado) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(climaAdequado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateClimaAdequado(ClimaAdequado climaAdequado) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(climaAdequado);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        var jpql = "DELETE FROM T_G_CLIMA_ADEQUADO ca where id = :id";
        var query = entityManager.createQuery(jpql, ClimaAdequado.class);
        query.setParameter("id", id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
