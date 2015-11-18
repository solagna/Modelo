/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author Emanuele
 */
@Entity
@Table(name = "entrada")
public class Entrada implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_entrada", sequenceName = "seq_entrada_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_entrada", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;
    
    @NotNull(message = "O nota deve ser informado")
    @NotBlank(message = "O nota nao pode ficar em branco!")
    @Length(max = 20, message = "O nota nao pode ter mais de {max} caracteres.")
    @Column(name = "nota", length = 20 , nullable = false)
    private String nota;
    
    @NotNull(message = "O valor total deve ser informado.")
    @Column(name = "valorTotal", nullable = false, columnDefinition = "decimal(12,2)")
    @Range(min = 0)
    private Double valorTotal;
    
    @OneToMany(mappedBy = "entrada", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EntradaItens> itens = new ArrayList<>();

    public Entrada() {
    }

    
     public void adicionarItens(EntradaItens obj) {
        obj.setEntrada(this);
        this.itens.add(obj);
    }
    public void removerItens(int index){
        this.itens.remove(id);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entrada other = (Entrada) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<EntradaItens> getItens() {
        return itens;
    }

    public void setItens(List<EntradaItens> itens) {
        this.itens = itens;
    }
    
    
    
}
