/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.PessoaJuridica;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class TesteInserirPessoaJuridica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try {
            emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
            em = emf.createEntityManager();
            PessoaJuridica pf = new PessoaJuridica();
            pf.setBairro("Centro");
            pf.setCep("99025002");
            pf.setCidade(em.find(Cidade.class, 1));
            pf.setComplemento("Apto 1003");
            pf.setCnpj("73.878.982/0001-92");
            pf.setEmail("juliapassamani@me.com");
            pf.setEndereco("Avenida brasil Oeste");
            pf.setNome("Julia");
            pf.setIe("111111111111");
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
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
