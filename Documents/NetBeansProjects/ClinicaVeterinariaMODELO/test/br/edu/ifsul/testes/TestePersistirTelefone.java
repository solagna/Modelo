package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Telefone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirTelefone {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirTelefone() {
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
            Medico m = em.find(Medico.class, 3);
                       
            Telefone t = new Telefone();
            t.setNumero("9965-1462");
            t.setDescricao("residencial");
            m.adicionarTelefone(t);
            
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
