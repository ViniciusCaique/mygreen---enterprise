package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.models.Plantacao;

public class PlantacaoRepository {

    private EntityManager entityManager;

    public PlantacaoRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public Iterable<Plantacao> findAll() {
        var jpql = "SELECT pl FROM T_G_PLANTACAO pl";
        var query = entityManager.createQuery(jpql, Plantacao.class);
        var plantacoes = query.getResultList();
        return plantacoes;
    }

    public Plantacao findById(Long id) {
        var jpql = "SELECT pl FROM T_G_PLANTACAO pl where id = :id";
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

    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        var jpql = "DELETE FROM T_G_PLANTACAO pl where id = :id";
        var query = entityManager.createQuery(jpql, Plantacao.class);
        query.setParameter("id", id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
