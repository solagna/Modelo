/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Telefone;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Emanuele
 */
@Stateless
public class TelefoneDAO implements Serializable {

    @PersistenceContext(unitName = "webPU")
    private EntityManager em;
    private List<Telefone> listarTodos;

    public TelefoneDAO() {
    }

    public void persist(Telefone obj) throws Exception {

        em.persist(obj);
    }

    public void merge(Telefone obj) throws Exception {

        em.merge(obj);
    }

    public void remove(Telefone obj) throws Exception {

        obj = em.merge(obj);
        em.remove(obj);
    }
    
    
    public EntityManager getEm() {
        return em;
    }

    public Telefone getObjectById(Integer id) throws Exception {

        return (Telefone) em.find(Telefone.class, id);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Telefone> getListarTodos() {
        return em.createQuery("from Telefone").getResultList();
    }

    public void setListarTodos(List<Telefone> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
