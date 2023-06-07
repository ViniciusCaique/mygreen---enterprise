package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.models.Usuario;

public class UsuarioRepository {

    private EntityManager entityManager;

    public UsuarioRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public Iterable<Usuario> findAll() {
        var jpql = "SELECT u FROM Usuario u";
        var query = entityManager.createQuery(jpql, Usuario.class);
        var usuarios = query.getResultList();
        return usuarios;
    }

    public Usuario findById(int id) {
        var jpql = "SELECT u FROM Usuario u where u.id = :id";
        var query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("id", id);
        var usuario = query.getSingleResult();
        return usuario;
    }

    public void createUsuario(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateUsuario(Usuario usuario) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteUsuarioById(int id) {
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("DELETE FROM Usuario where id =" + id);
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

}
