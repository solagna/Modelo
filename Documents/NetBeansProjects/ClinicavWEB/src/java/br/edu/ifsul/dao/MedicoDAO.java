/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Medico;
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
public class MedicoDAO implements Serializable{
    
    @PersistenceContext(unitName = "webPU")
    private EntityManager em;
    private List<Medico> listarTodos;

    public MedicoDAO() {
    }

    public void persist(Medico obj) throws Exception {

        em.persist(obj);
    }

    public void merge(Medico obj) throws Exception {

        em.merge(obj);
    }

    public void remove(Medico obj) throws Exception {

        obj = em.merge(obj);
        em.remove(obj);
    }
    
    
    public EntityManager getEm() {
        return em;
    }

    public Medico getObjectById(Integer id) throws Exception {

        return (Medico) em.find(Medico.class, id);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Medico> getListarTodos() {
        return em.createQuery("from Medico order by id").getResultList();
    }

    public void setListarTodos(List<Medico> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
