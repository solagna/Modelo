package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirMedicos{
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMedicos() {
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
            Medico m = new Medico();            
            m.setEmail("paola@hotmail.com");
            m.setNome("Paola Buzz");                              
            m.setCidade("Passo Fundo");
            m.setEndereco("Av. Presidente Vargas, 969");
            m.setCrm(99998887);
            m.setEspecialidade("Pediatra");
            m.setFolga("quinta-feira");
            m.setCargaHoraria(20.0);
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
