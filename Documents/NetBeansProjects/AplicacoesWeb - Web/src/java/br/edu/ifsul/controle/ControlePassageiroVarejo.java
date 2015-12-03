/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AssentoDAO;
import br.edu.ifsul.dao.VarejoDAO;
import br.edu.ifsul.modelo.PassageiroVarejo;
import br.edu.ifsul.modelo.Reserva;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Emanuele
 */
@ManagedBean(name = "controlePassageiroVarejo")
@ViewScoped
public class ControlePassageiroVarejo implements Serializable {

    private VarejoDAO dao;
    private PassageiroVarejo objeto;
    private Reserva reserva;
    private Boolean novaReserva;
    private AssentoDAO daoAssento;

    public ControlePassageiroVarejo() {
        dao = new VarejoDAO();
        daoAssento = new AssentoDAO();
    }

    public String listar() {
        return "/privado/passageiro_varejo/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new PassageiroVarejo();
    }

    public AssentoDAO getDaoAssento() {
        return daoAssento;
    }

    public void setDaoAssento(AssentoDAO daoAssento) {
        this.daoAssento = daoAssento;
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

    public void novaReserva() {
        this.reserva = new Reserva();
        this.novaReserva = true;
    }

    public void alterarReserva(int index) {
        this.reserva = objeto.getReservas().get(index);
        this.novaReserva = false;
    }

    public void salvarReserva() {
        if (novaReserva) {
            objeto.adicionarReserva(reserva);
        }
        Util.mensagemInformacao("Operação realizada com sucesso!");
    }

    public void removerReserva(int index) {
        objeto.removerReserva(index);
        Util.mensagemInformacao("Operação realizada com sucesso!");
    }

    public VarejoDAO getDao() {
        return dao;
    }

    public void setDao(VarejoDAO dao) {
        this.dao = dao;
    }

    public PassageiroVarejo getObjeto() {
        return objeto;
    }

    public void setObjeto(PassageiroVarejo objeto) {
        this.objeto = objeto;
    }

    public Boolean getNovaReserva() {
        return novaReserva;
    }

    public void setNovaReserva(Boolean novaReserva) {
        this.novaReserva = novaReserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

   }
