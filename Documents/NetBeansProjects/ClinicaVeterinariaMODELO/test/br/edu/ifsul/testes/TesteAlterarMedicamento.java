package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medicamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteAlterarMedicamento {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteAlterarMedicamento() {
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
            Medicamento m = em.find(Medicamento.class, 4);
            m.setEstoque(90.0);
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
