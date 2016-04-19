package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.Venda;
import br.edu.ifsul.modelo.VendaID;
import br.edu.ifsul.modelo.VendaItens;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirVenda {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirVenda() {
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
            
            Venda v = new Venda();
            VendaID id = new VendaID();
            
            id.setNumeroNota(1654459989);
            id.setPaciente(em.find(Paciente.class, 1));
            
            v.setId(id);
            v.setData(Calendar.getInstance());
            v.setPagamento("Cartao");
//            v.setValorTotal(Double.MIN_NORMAL);

            VendaItens item = new VendaItens();                  
            item.setMedicamento(em.find(Medicamento.class, 4));
            item.setQuantidade(3.0);
            item.setTotal(item.getMedicamento().getPreco());
            
            v.adicionarItem(item);
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        }catch (Exception e){
        
            exception = true;
            e.printStackTrace();
        }
    
        Assert.assertEquals(false, exception);
    }
    
}
