package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.modelo.Medico;
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

public class TestePersistirConsulta {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirConsulta() {
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
    public void teste() {
        
        boolean exception = false;
        try {
            Consulta c = new Consulta();
            c.setDataAgendamento(new GregorianCalendar(1979, Calendar.OCTOBER, 25));
            c.setDataConsulta(new GregorianCalendar(2016, Calendar.APRIL, 25));
            c.setDataPagamento(Calendar.getInstance());
            c.setDescricao("Tratamento para dor.");
            c.setMedico(em.find(Medico.class, 3));
            c.setPaciente(em.find(Paciente.class, 1));
            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
