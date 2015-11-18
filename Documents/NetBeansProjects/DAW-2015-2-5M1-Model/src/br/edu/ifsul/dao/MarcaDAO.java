/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Marca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class MarcaDAO {
    private List<Marca> listarTodos;

    public MarcaDAO() {
    }

    public void persistir(Marca objeto) throws Exception {
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

    public void merge(Marca objeto) throws Exception {
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            Marca objeto = em.find(Marca.class, id);

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

    public Marca getObjectById(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Marca.class, id);

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

    public List<Marca> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("from Marca order by nome").getResultList();
        } catch (Exception e) {
            throw new Exception("ERRO NA OPERAÇÃO DE PERSISTENCIA: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Marca> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
