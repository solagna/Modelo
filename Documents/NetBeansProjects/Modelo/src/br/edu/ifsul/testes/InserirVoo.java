/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Voo;
import java.util.Calendar;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


/**
 *
 * @author Emanuele
 */
public class InserirVoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = null;
        EntityManagerFactory emf = null;

        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoPU");
            em = emf.createEntityManager();

            Voo v = new Voo();
            v.setData(Calendar.getInstance());
            v.setStatus("Cancelado");
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().commit();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

}
