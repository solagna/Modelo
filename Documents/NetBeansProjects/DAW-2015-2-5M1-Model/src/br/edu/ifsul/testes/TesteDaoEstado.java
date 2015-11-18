/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.dao.EstadoDAO;

/**
 *
 * @author Emanuele dao
 */
public class TesteDaoEstado {

    public static void main(String[] args) throws Exception {

        EstadoDAO dao = new EstadoDAO();
        Estado e1 = new Estado();
        e1.setNome("Minas gerais");
        e1.setUf("MG");
        dao.persistir(e1);

        for (Estado e : dao.getListarTodos()) {
            System.out.println("ID: " + e.getId() + " Nome: " + e.getNome());
        }
    }

}
