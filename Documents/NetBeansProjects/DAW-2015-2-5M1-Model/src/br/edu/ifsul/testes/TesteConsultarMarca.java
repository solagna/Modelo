/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Marca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emanuele
 */
public class TesteConsultarMarca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        emf = Persistence.createEntityManagerFactory("DAW-2015-2-5M1-ModelPU");
        em = emf.createEntityManager();

        String busca = "Asus";
        Boolean b = false;

        List<Marca> lista = em.createQuery("from Marca order by nome").getResultList();

        for (Marca e : lista) {

            if (e.getNome().toUpperCase().equals(busca.toUpperCase())) {
                System.out.println("ID: " + e.getId() + " Nome: " + e.getNome());
                break;
            } else {
                System.out.println("Não foram encontrados registros com esse nome.");
                break;
            }

        }

        em.close();
        emf.close();
    }

}
