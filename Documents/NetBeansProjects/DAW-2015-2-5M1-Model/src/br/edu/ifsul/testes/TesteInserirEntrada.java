/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Entrada;
import br.edu.ifsul.modelo.EntradaItens;
import br.edu.ifsul.modelo.Produto;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class TesteInserirEntrada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
            em = emf.createEntityManager();
           
            Entrada e = new Entrada();
            EntradaItens ei = new EntradaItens();
            
            e.setData(Calendar.getInstance());
            e.setNota("1111");
            e.setValorTotal(10000.00);
            Produto p = em.find(Produto.class, 1);
            ei.setProduto(p);
            ei.setQuantidade(12.0);
            ei.setValor_total(2000.00);
            ei.setValor_unitario(10.00);
            e.adicionarItens(ei);
          
            
            em.getTransaction().begin();
            em.persist(e);
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
