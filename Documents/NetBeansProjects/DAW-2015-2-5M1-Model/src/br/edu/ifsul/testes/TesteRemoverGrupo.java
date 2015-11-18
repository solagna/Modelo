/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Marca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class TesteRemoverGrupo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
            em = emf.createEntityManager();

            Grupo m = em.find(Grupo.class, 3);
            em.getTransaction().begin();
            em.remove(m);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                e.printStackTrace();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
    
}
