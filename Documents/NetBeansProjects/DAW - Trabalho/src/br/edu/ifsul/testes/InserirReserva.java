/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Assento;
import br.edu.ifsul.modelo.PassageiroCorporativo;
import br.edu.ifsul.modelo.Reserva;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class InserirReserva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//           Responsável por estabelecer a conexão com o banco e criar as EntitysManagers
        EntityManagerFactory emf = null;
        //Gerenciador de entidades
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoPU");
            em = emf.createEntityManager();
            Reserva r = new Reserva();
            r.setData(Calendar.getInstance());
            r.setValidade(Calendar.getInstance());
            Assento s = em.find(Assento.class, 1);
            r.setAssento(s);     
        
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            if(em.getTransaction().isActive() == false) {
                em.getTransaction().commit();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
    
}
