/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AssentoDAO;
import br.edu.ifsul.dao.ReservaDAO;
import br.edu.ifsul.dao.VarejoDAO;
import br.edu.ifsul.modelo.Assento;
import br.edu.ifsul.modelo.Passageiro;
import br.edu.ifsul.modelo.Reserva;
import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Emanuele
 */
@ManagedBean(name = "controleReserva")
@ViewScoped
public class ControleReserva implements Serializable {

    private ReservaDAO dao;
    private Reserva objeto;
    private Boolean novoPassageiro;
    private Passageiro passageiro;
    private Assento assento;
    private AssentoDAO daoAssento;

    public ControleReserva() {
        dao = new ReservaDAO();
        daoAssento = new AssentoDAO();
    }

    public String listar() {
        return "/privado/reserva/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Reserva();
    }

    public void salvar() {
        try {
            if (objeto.getNumero() == null) {
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

    public ReservaDAO getDao() {
        return dao;
    }

    public void setDao(ReservaDAO dao) {
        this.dao = dao;
    }

    public Reserva getObjeto() {
        return objeto;
    }

    public void setObjeto(Reserva objeto) {
        this.objeto = objeto;
    }

    public Boolean getNovoPassageiro() {
        return novoPassageiro;
    }

    public void setNovoPassageiro(Boolean novoPassageiro) {
        this.novoPassageiro = novoPassageiro;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public AssentoDAO getDaoAssento() {
        return daoAssento;
    }

    public void setDaoAssento(AssentoDAO daoAssento) {
        this.daoAssento = daoAssento;
    }

}
