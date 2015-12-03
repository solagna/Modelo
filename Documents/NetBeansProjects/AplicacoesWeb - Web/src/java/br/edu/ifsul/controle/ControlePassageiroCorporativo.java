/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AssentoDAO;
import br.edu.ifsul.dao.CorporativoDAO;
import br.edu.ifsul.modelo.PassageiroCorporativo;
import br.edu.ifsul.modelo.Reserva;
import br.edu.ifsul.util.Util;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Emanuele
 */
@ManagedBean(name = "controlePassageiroCorporativo")
@ViewScoped
public class ControlePassageiroCorporativo {
    
    private CorporativoDAO dao;
    private PassageiroCorporativo objeto;
    private Reserva reserva;
    private AssentoDAO daoAssento;
    private Boolean novaReserva;

    public ControlePassageiroCorporativo() {
        this.dao = new CorporativoDAO();
        //this.daoAssento = new AssentoDAO();
    }

    public String listar() {
        return "/privado/passageiro_corporativo/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new PassageiroCorporativo();
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

    public CorporativoDAO getDao() {
        return dao;
    }

    public void setDao(CorporativoDAO dao) {
        this.dao = dao;
    }

    public PassageiroCorporativo getObjeto() {
        return objeto;
    }

    public void setObjeto(PassageiroCorporativo objeto) {
        this.objeto = objeto;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public AssentoDAO getDaoAssento() {
        return daoAssento;
    }

    public void setDaoAssento(AssentoDAO daoAssento) {
        this.daoAssento = daoAssento;
    }

    public Boolean getNovaReserva() {
        return novaReserva;
    }

    public void setNovaReserva(Boolean novaReserva) {
        this.novaReserva = novaReserva;
    }

 
}
