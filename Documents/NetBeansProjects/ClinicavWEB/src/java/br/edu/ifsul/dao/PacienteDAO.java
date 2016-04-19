/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Paciente;
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
public class PacienteDAO implements Serializable{
    
    @PersistenceContext(unitName = "webPU")
    private EntityManager em;
    private List<Paciente> listarTodos;

    public PacienteDAO() {
    }

    public void persist(Paciente obj) throws Exception {

        em.persist(obj);
    }

    public void merge(Paciente obj) throws Exception {

        em.merge(obj);
    }

    public void remove(Paciente obj) throws Exception {

        obj = em.merge(obj);
        em.remove(obj);
    }
    
    
    public EntityManager getEm() {
        return em;
    }

    public Paciente getObjectById(Integer id) throws Exception {

        return (Paciente) em.find(Paciente.class, id);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Paciente> getListarTodos() {
        return em.createQuery("from Paciente order by id").getResultList();
    }

    public void setListarTodos(List<Paciente> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
