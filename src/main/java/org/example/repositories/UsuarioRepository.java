package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.models.Usuario;

import java.util.List;

public class UsuarioRepository {

    private EntityManager entityManager;

    public UsuarioRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public Iterable<Usuario> findAll() {
        var jpql = "SELECT u FROM T_G_USUARIO u";
        var query = entityManager.createQuery(jpql, Usuario.class);
        var usuarios = query.getResultList();
        return usuarios;
    }

    public Usuario findById(Long id) {
        var jpql = "SELECT u FROM T_G_USUARIO u where id = :id";
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

    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        var jpql = "DELETE FROM T_G_USUARIO u where id = :id";
        var query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("id", id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }


}
