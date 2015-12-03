/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aeroporto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class InserirAeroporto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = null;
        EntityManagerFactory emf = null;
        
        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoPU");
            em = emf.createEntityManager();

            Aeroporto a = new Aeroporto();
            a.setNome("Guarulhos");
            a.setEndereco("Av. Washington Luís, s/nº - Vila Congonhas.");
            a.setEstado("SP");
            a.setCidade("São Paulo");

            em.getTransaction().begin();
            em.persist(a);
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
