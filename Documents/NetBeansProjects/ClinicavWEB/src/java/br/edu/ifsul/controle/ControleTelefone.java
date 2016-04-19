package br.edu.ifsul.controle;

import br.edu.ifsul.dao.TelefoneDAO;
import br.edu.ifsul.modelo.Telefone;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controleTelefone")
@SessionScoped
public class ControleTelefone implements Serializable {

    @EJB
    private TelefoneDAO dao;
    private Telefone objeto;

    public ControleTelefone() {
    }

    public String listar() {

        return "/privado/telefone/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Telefone();

    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);

            } else {
                dao.merge(objeto);
            }
            UtilMensagem.mensagemInformacao("Objeto persistido com sucesso");
   
        } catch (Exception e) {
            UtilMensagem.mensagemErro("Erro ao persistir" + e.getMessage());
        }

    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);

        } catch (Exception e) {
            UtilMensagem.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
        }

    }

    public void remover(Integer id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            UtilMensagem.mensagemInformacao("Objeto removido com sucesso!");

        } catch (Exception e) {

            UtilMensagem.mensagemErro("Erro ao remover o objeto " + e.getMessage());
        }
    }

    public TelefoneDAO getDao() {
        return dao;
    }

    public void setDao(TelefoneDAO dao) {
        this.dao = dao;
    }

    public Telefone getObjeto() {
        return objeto;
    }

    public void setObjeto(Telefone objeto) {
        this.objeto = objeto;
    }
}
