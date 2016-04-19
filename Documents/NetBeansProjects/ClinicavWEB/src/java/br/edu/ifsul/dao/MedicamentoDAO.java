/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Medicamento;
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
public class MedicamentoDAO implements Serializable {

    @PersistenceContext(unitName = "webPU")
    private EntityManager em;
    private List<Medicamento> listarTodos;

    public MedicamentoDAO() {
    }

    public void persist(Medicamento obj) throws Exception {

        em.persist(obj);
    }

    public void merge(Medicamento obj) throws Exception {

        em.merge(obj);
    }

    public void remove(Medicamento obj) throws Exception {

        obj = em.merge(obj);
        em.remove(obj);
    }
    
    
    public EntityManager getEm() {
        return em;
    }

    public Medicamento getObjectById(Integer id) throws Exception {

        return (Medicamento) em.find(Medicamento.class, id);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Medicamento> getListarTodos() {
        return em.createQuery("from Medicamento order by id").getResultList();
    }

    public void setListarTodos(List<Medicamento> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
