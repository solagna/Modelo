package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AeroportoDAO;
import br.edu.ifsul.dao.AssentoDAO;
import br.edu.ifsul.dao.VooDAO;
import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Assento;
import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emanuele
 */
@ManagedBean(name = "controleVoo")
@ViewScoped
public class ControleVoo implements Serializable {

    private VooDAO dao;
    private Voo objeto;

    private Aeroporto aeroporto;
    private AeroportoDAO daoAeroporto;
    private Boolean novoAeroporto;

    private Boolean novoAssento;
    private Assento assento;

    public ControleVoo() {
        daoAeroporto = new AeroportoDAO();
        dao = new VooDAO();
    }

    public String listar() {
        return "/privado/voo/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Voo();
    }

//    public void novoAssento() {
//        assento = new Assento();
//        this.novoAssento = true;
//    }

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
        if (aeroporto != null) {
            if (!objeto.getEscalas().contains(aeroporto)) {
                objeto.getEscalas().add(aeroporto);
                Util.mensagemInformacao("Escala adicionada com sucesso!");
            } else {
                Util.mensagemErro("Esta escala já existente na lista!");
            }
        }
    }

    public void removerEscala(int idx) {
        Aeroporto a = objeto.getEscalas().get(idx);
        objeto.getEscalas().remove(a);
        Util.mensagemInformacao("Voo removido");
    }

    public VooDAO getDao() {
        return dao;
    }

    public void setDao(VooDAO dao) {
        this.dao = dao;
    }

    public Voo getObjeto() {
        return objeto;
    }

    public void setObjeto(Voo objeto) {
        this.objeto = objeto;
    }

    public Aeroporto getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
    }

    public AeroportoDAO getDaoAeroporto() {
        return daoAeroporto;
    }

    public void setDaoAeroporto(AeroportoDAO daoAeroporto) {
        this.daoAeroporto = daoAeroporto;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public Boolean getNovoAssento() {
        return novoAssento;
    }

    public void setNovoAssento(Boolean novoAssento) {
        this.novoAssento = novoAssento;
    }

    public Boolean getNovoAeroporto() {
        return novoAeroporto;
    }

    public void setNovoAeroporto(Boolean novoAeroporto) {
        this.novoAeroporto = novoAeroporto;
    }

}
