/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class TesteInserirProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
            em = emf.createEntityManager();
            Produto p = new Produto();
            p.setNome("Notebook");
            p.setEstoque(12.0);
            p.setDescricao("computador");
            Grupo g = em.find(Grupo.class, 1);
            p.setGrupo(g);
            Marca m = em.find(Marca.class, 1);
            p.setMarca(m);
            p.setPreco(2000.00);
            em.getTransaction().begin();
            em.persist(p);
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
