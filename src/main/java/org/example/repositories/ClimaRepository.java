package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.models.Clima;

public class ClimaRepository {

    private EntityManager entityManager;

    public ClimaRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public Iterable<Clima> findAll() {
        var jpql = "SELECT c FROM T_G_CLIMA c";
        var query = entityManager.createQuery(jpql, Clima.class);
        var climas = query.getResultList();
        return climas;
    }

    public Clima findById(Long id) {
        var jpql = "SELECT c FROM T_G_CLIMA c where id = :id";
        var query = entityManager.createQuery(jpql, Clima.class);
        query.setParameter("id", id);
        var clima = query.getSingleResult();
        return clima;
    }

    public void createClima(Clima clima) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(clima);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateClima(Clima clima) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(clima);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        var jpql = "DELETE FROM T_G_CLIMA c where id = :id";
        var query = entityManager.createQuery(jpql, Clima.class);
        query.setParameter("id", id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
