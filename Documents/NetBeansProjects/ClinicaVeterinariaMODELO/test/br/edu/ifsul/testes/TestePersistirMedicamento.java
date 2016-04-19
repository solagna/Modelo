package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medicamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirMedicamento {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMedicamento() {
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
            Medicamento m = new Medicamento();
            m.setNome("Tylenol");
            m.setEstoque(11.0);
            m.setPreco(15.92);
            m.setDescricao("Tratamento de dor.");
        
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        }catch (Exception e){
            
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
