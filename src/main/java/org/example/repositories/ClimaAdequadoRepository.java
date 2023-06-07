package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.models.ClimaAdequado;

public class ClimaAdequadoRepository {

    private EntityManager entityManager;

    public ClimaAdequadoRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public Iterable<ClimaAdequado> findAll() {
        var jpql = "SELECT ca FROM ClimaAdequado ca";
        var query = entityManager.createQuery(jpql, ClimaAdequado.class);
        var climasAde = query.getResultList();
        return climasAde;
    }

    public ClimaAdequado findById(int id) {
        var jpql = "SELECT ca FROM ClimaAdequado ca where id = :id";
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

    public void deleteClimaAdequadoById(int id) {
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("DELETE FROM ClimaAdequado where id =" + id);
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
