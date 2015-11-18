/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class EstadoDAO implements Serializable {

    private List<Estado> listarTodos;

    public EstadoDAO() {
    }

    public void persistir(Estado objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }

            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("ERRO NA OPERAÇÃO DE PERSISTENCIA " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }

    public void merge(Estado objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }

            em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("ERRO NA OPERAÇÃO DE PERSISTENCIA " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }

    public void remover(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DDAW-2015-2-5M1-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            Estado objeto = em.find(Estado.class, id);

            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("ERRO NA OPERAÇÃO DE PERSISTENCIA " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }

    public Estado getObjectById(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Estado.class, id);

        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("ERRO NA OPERAÇÃO DE PERSISTENCIA " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }

    public List<Estado> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("from Estado order by nome").getResultList();
        } catch (Exception e) {
            throw new Exception("ERRO NA OPERAÇÃO DE PERSISTENCIA: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }

    public void setListarTodos(List<Estado> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
