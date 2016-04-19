package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteListarMedicos{
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteListarMedicos() {
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
             List<Medico> lista = em.createQuery("from Medico order by id").getResultList();
        
        for(Medico m : lista){
            System.out.println("ID: " + m.getId() + " Nome: " + m.getNome());
        }
            
        }catch (Exception e){
       
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
