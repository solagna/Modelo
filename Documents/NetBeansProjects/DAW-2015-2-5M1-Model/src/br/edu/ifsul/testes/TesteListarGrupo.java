/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Grupo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class TesteListarGrupo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
        em = emf.createEntityManager();
      
        List<Grupo> lista = em.createQuery("from Grupo order by id").getResultList();
        
        for(Grupo g : lista){
            System.out.println("ID: " + g.getId() + " Nome: " + g.getNome());
        }
        em.close();
        emf.close();
    }
    }
    

