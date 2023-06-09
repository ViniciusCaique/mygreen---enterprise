package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.models.Planta;

public class PlantaRepository {

    private EntityManager entityManager;

    public PlantaRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public Iterable<Planta> findAll() {
        var jpql = "SELECT p FROM Planta p";
        var query = entityManager.createQuery(jpql, Planta.class);
        var plantas = query.getResultList();
        return plantas;
    }

    public Planta findById(int id) {
        var jpql = "SELECT p FROM Planta p where id = :id";
        var query = entityManager.createQuery(jpql, Planta.class);
        query.setParameter("id", id);
        var planta = query.getSingleResult();
        return planta;
    }

    public void createPlanta(Planta planta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(planta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updatePlanta(Planta planta) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(planta);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deletePlantaById(int id) {
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("DELETE FROM Planta where id =" + id);
            query.executeUpdate();
//            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
