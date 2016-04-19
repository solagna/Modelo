package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.Venda;
import br.edu.ifsul.modelo.VendaID;
import br.edu.ifsul.modelo.VendaItens;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TesteListarItensVenda {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteListarItensVenda() {
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
                        
            VendaID id = new VendaID();
            id.setNumeroNota(1654459989);
            
            id.setPaciente(em.find(Paciente.class,1));
            Venda v = em.find(Venda.class, id);
            for (VendaItens ci : v.getItens()){
                System.out.println("Produto: "+ci.getMedicamento().getNome() +
                        " Valor Total: "+ci.getTotal());
            }
        }catch (Exception e){
            // se gerar exceção 
            exception = true;
            e.printStackTrace();
        }
        // compara se não ocorreu erro
        Assert.assertEquals(false, exception);
    }
    
}
