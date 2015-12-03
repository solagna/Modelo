/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AeroportoDAO;
import br.edu.ifsul.dao.VooDAO;
import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Emanuele
 */
@ManagedBean(name = "controleAeroporto")
@ViewScoped
public class ControleAeroporto implements Serializable {

    private AeroportoDAO dao;
    private Aeroporto objeto;
    
    private Voo voo;
    private VooDAO vooDAO;
    private Boolean novoVoo;

    public ControleAeroporto() {
        vooDAO = new VooDAO();
        dao = new AeroportoDAO();
    }

    public String listar() {
        return "/privado/aeroporto/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Aeroporto();
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

    public void adicionarEscala() {
        if (voo != null) {
            if (!objeto.getEscalas().contains(voo)) {
                objeto.getEscalas().add(voo);
                Util.mensagemInformacao("Escala adicionada com sucesso!");
            } else {
                Util.mensagemErro("Esta escala já existente na lista!");
            }
        }
    }

    public void removerEscala(int idx) {
        Voo v = objeto.getEscalas().get(idx);
        objeto.getEscalas().remove(v);
        Util.mensagemInformacao("Voo removido");
    }

    public AeroportoDAO getDao() {
        return dao;
    }

    public void setDao(AeroportoDAO dao) {
        this.dao = dao;
    }

    public Aeroporto getObjeto() {
        return objeto;
    }

    public void setObjeto(Aeroporto objeto) {
        this.objeto = objeto;
    }

    public Voo getVoos() {
        return voo;
    }

    public void setVoos(Voo voos) {
        this.voo = voos;
    }

    public Boolean getNovoVoo() {
        return novoVoo;
    }

    public void setNovoVoo(Boolean novoVoo) {
        this.novoVoo = novoVoo;
    }

    public VooDAO getVooDAO() {
        return vooDAO;
    }

    public void setVooDAO(VooDAO vooDAO) {
        this.vooDAO = vooDAO;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

}
