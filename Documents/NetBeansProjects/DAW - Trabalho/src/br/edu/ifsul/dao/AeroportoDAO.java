/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Aeroporto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class AeroportoDAO implements Serializable{

    private List<Aeroporto> listarTodos;

    public AeroportoDAO() {

    }

    public void persist(Aeroporto objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
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
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void merge(Aeroporto objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
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
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void remove(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            Aeroporto objeto = em.find(Aeroporto.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de remoção: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public Aeroporto getObjectById(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Aeroporto.class, id);
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Aeroporto> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Aeroporto order by nome").getResultList();
        } catch (Exception e) {
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Aeroporto> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
