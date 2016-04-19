/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Emanuele
 */
@Entity
@Table(name = "medicamento")
public class Medicamento implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_medicamento", sequenceName = "seq_medicamento_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_medicamento", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Length(max = 100, message = "A descricao nao pode ter mais de {max} caracteres.")
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @NotNull(message = "O preço deve ser informado")
    @Column(name = "preco", nullable = false, columnDefinition = "decimal(12,2)")
    private Double preco;
    
    @NotNull(message = "O estoque deve ser informado")
    @Column(name = "estoque", nullable = false, columnDefinition = "decimal(12,2)")
    private Double estoque;
    
    @ManyToMany
    @JoinTable(name = "receitados", joinColumns = @JoinColumn(name = "medicamento", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "consulta", referencedColumnName = "id"))
    private List<Consulta> receitados = new ArrayList<>();

    public List<Consulta> getReceitados() {
        return receitados;
    }

    public void setReceitados(List<Consulta> receitados) {
        this.receitados = receitados;
    }

    public Medicamento() {
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medicamento other = (Medicamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }
    
    
}
