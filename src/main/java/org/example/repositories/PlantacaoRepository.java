package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.models.Plantacao;

public class PlantacaoRepository {

    private EntityManager entityManager;

    public PlantacaoRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public Iterable<Plantacao> findAll() {
        var jpql = "SELECT pl FROM Plantacao pl";
        var query = entityManager.createQuery(jpql, Plantacao.class);
        var plantacoes = query.getResultList();
        return plantacoes;
    }

    public Plantacao findById(int id) {
        var jpql = "SELECT pl FROM Plantacao pl where id = :id";
        var query = entityManager.createQuery(jpql, Plantacao.class);
        query.setParameter("id", id);
        var plantacao = query.getSingleResult();
        return plantacao;
    }

    public void createPlantacao(Plantacao plantacao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(plantacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updatePlantacao(Plantacao plantacao) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(plantacao);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deletePlantacaoById(int id) {
        try{
            entityManager.getTransaction().begin();
//            var jpql = "DELETE FROM Plantacao pl where id = :id";
//            Query query = entityManager.createQuery(jpql, Plantacao.class);
//            query.setParameter("id", id).executeUpdate();
//            var plantacao = findById(id);
//            var jpql = "SELECT pl FROM Plantacao pl where id = :id";
//            var query = entityManager.createQuery(jpql, Plantacao.class);
//            query.setParameter("id", id);
//            var plantacao = query.getSingleResult();
//            entityManager.remove(plantacao);
            Query query1 = entityManager.createQuery("DELETE FROM Plantacao where id =" + id);
            query1.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
