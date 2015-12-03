package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "assento")
public class Assento implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_assento", sequenceName = "seq_assento_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_assento", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O status deve ser informado.")
    @Column(name = "status", length = 50, nullable = false)
    private boolean status;
    @NotNull(message = "O preço total deve ser válido.")
    @Range(min = 0)
    private Double preco;
    @NotNull(message = "O tipo deve ser informado.")
    @NotBlank(message = "O tipo deve ser informado.")
    @NotEmpty(message = "O tipo deve ser informado.")
    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;
       
    @ManyToOne
    @JoinColumn(name = "voo", referencedColumnName = "id", nullable = false)
    private Voo voo;

    public Assento() {
    }
      
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
