package com.ejemplo.dao;

import com.ejemplo.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import java.util.List;

public class UsuarioDAOImpl implements GenericDAO<Usuario> {

    private EntityManager em;

    public UsuarioDAOImpl() {
        // Configurar el EntityManager manualmente
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticaJakartaPU"); // Asegúrate de que el nombre coincida con el de persistence.xml
        this.em = emf.createEntityManager();
    }

    @Override
    public Usuario encontrarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> encontrarTodos() {
        return em.createQuery("FROM Usuario", Usuario.class).getResultList();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        em.getTransaction().begin(); // Iniciar transacción manualmente
        em.persist(usuario);
        em.getTransaction().commit(); // Confirmar la transacción
    }

    @Override
    @Transactional
    public void actualizar(Usuario usuario) {
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        em.getTransaction().begin();
        if (em.contains(usuario)) {
            em.remove(usuario);
        } else {
            em.remove(em.merge(usuario));
        }
        em.getTransaction().commit();
    }
}
