package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteAlterarMedicos{
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteAlterarMedicos() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("persistencia");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
       
        boolean exception = false;
        try {
            Medico m = em.find(Medico.class, 16);
            m.setCargaHoraria(20.0);
            em.getTransaction().begin();
            em.merge(m);
            em.getTransaction().commit();
        }catch (Exception e){
       
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
