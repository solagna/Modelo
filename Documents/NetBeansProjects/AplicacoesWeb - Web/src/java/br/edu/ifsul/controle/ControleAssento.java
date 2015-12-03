/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AssentoDAO;
import br.edu.ifsul.dao.VooDAO;
import br.edu.ifsul.modelo.Assento;
import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Emanuele
 */
@ManagedBean(name = "controleAssento")
@ViewScoped
public class ControleAssento implements Serializable{

    private AssentoDAO dao;
    private Assento objeto;
    private VooDAO vooDAO;
   

    public ControleAssento() {
        dao = new AssentoDAO();
        vooDAO = new VooDAO();

    }

    public String listar() {
        return "/privado/assento/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Assento();
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro(e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro(e.getMessage());
        }
    }

    public void remover(Integer id) {
        try {
            dao.remove(id);
        } catch (Exception e) {
            Util.mensagemErro(e.getMessage());
        }
    }

    public AssentoDAO getDao() {
        return dao;
    }

    public void setDao(AssentoDAO dao) {
        this.dao = dao;
    }

    public Assento getObjeto() {
        return objeto;
    }

    public void setObjeto(Assento objeto) {
        this.objeto = objeto;
    }

    public VooDAO getVooDAO() {
        return vooDAO;
    }

    public void setVooDAO(VooDAO vooDAO) {
        this.vooDAO = vooDAO;
    }

 

}
