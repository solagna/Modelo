/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.PassageiroCorporativo;
import br.edu.ifsul.modelo.PassageiroVarejo;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class InserirPassageiroCorporativo {

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
            PassageiroCorporativo obj = new PassageiroCorporativo();
   
            obj.setNome("Emanuele");
            obj.setCep("9999999");
            obj.setDataNascimento(Calendar.getInstance());
            obj.setEmail("emanuelesolagna@hotmail.com");
            obj.setEndereco("Mato castelhano");
            obj.setNomeEmpresa("Asus");
            obj.setNumeroConta("989898");
            obj.setPontosVoo(6);
            
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
