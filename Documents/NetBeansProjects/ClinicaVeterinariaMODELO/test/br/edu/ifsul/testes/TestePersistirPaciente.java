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

public class TestePersistirPaciente {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPaciente() {
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
            Paciente p = new Paciente();
            p.setCpf("036.451.560-03");
            p.setEmail("emanuelesolagna@hotmail.com");
            p.setNascimento(new GregorianCalendar(1979, Calendar.OCTOBER,25));
            p.setNome("Emanuele Solagna");
            p.setRg("7648569437");         
            p.setCadastro(new GregorianCalendar(1979, Calendar.OCTOBER,25));
            p.setCidade("Passo Fundo");
            p.setEndereco("Av. Presidente Vargas, 969");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch (Exception e){
       
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
