package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Paciente;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteAlterarPaciente {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteAlterarPaciente() {
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
            Paciente p = em.find(Paciente.class, 1);
            p.setCidade("Caxias do Sul");
            
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }catch (Exception e){
       
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
