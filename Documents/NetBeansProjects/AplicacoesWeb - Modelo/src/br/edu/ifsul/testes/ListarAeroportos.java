/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aeroporto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class ListarAeroportos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        EntityManager em = emf.createEntityManager();

        String jpql = "from Aeroporto";

        List<Aeroporto> lista = em.createQuery(jpql).getResultList();
        for (Aeroporto c : lista) {
            System.out.println("Id: " + c.getId() + " Nome: " + c.getNome() + "Cidade: " + c.getCidade());
        }

        em.close();
        emf.close();
    }
}
