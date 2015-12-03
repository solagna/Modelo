/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.PassageiroVarejo;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class InserirPassageiroVarejo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Responsável por estabelecer a conexão com o banco e criar as EntitysManagers
        EntityManagerFactory emf = null;
        //Gerenciador de entidades
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoPU");
            em = emf.createEntityManager();
            PassageiroVarejo obj = new PassageiroVarejo();
             
            obj.setCep("90909090");
            obj.setDataNascimento(Calendar.getInstance());
            obj.setEmail("emanuelsolagna@hotmail.com");
            obj.setNome("Manu");
            obj.setNumeroCartao("9090909");
            obj.setOperadoraCartao("normal");
            obj.setTipoCartao("Internacional");
            obj.setEndereco("Mato City");
                       
            em.getTransaction().begin();
            em.persist(obj);
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
