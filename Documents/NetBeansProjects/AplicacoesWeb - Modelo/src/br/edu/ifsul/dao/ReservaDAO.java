/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Reserva;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class ReservaDAO implements Serializable{

    private List<Reserva> listarTodos;

    public ReservaDAO() {

    }

    public void persist(Reserva objeto) throws Exception {
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

    public void merge(Reserva objeto) throws Exception {
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
            throw new Exception("Erro na operação de merge: " + e.getMessage());
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
            Reserva objeto = em.find(Reserva.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
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

    public Reserva getObjectById(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Reserva.class, id);
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

    public List<Reserva> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Reserva order by numero").getResultList();
        } catch (Exception e) {
            throw new Exception("Erro na operação de persistência: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Reserva> listarTodos) {
        this.listarTodos = listarTodos;
    }

    
}
