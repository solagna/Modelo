/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
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
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author Emanuele
 */
@Entity
@Table(name = "entrada_itens")
public class EntradaItens implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_itens", sequenceName = "seq_itens_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_itens", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "A quantidade deve ser informado.")
    @Column(name = "quantidade", nullable = false, columnDefinition = "decimal(12,2)")
    @Range(min = 0)
    private Double quantidade;

    @NotNull(message = "O valor_unitario total deve ser informado.")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "decimal(12,2)")
    @Range(min = 0)
    private Double valor_unitario;

    @NotNull(message = "O valor_total deve ser informado.")
    @Column(name = "valor_total", nullable = false, columnDefinition = "decimal(12,2)")
    @Range(min = 0)
    private Double valor_total;

    @NotNull(message = "O produto nao pode ser nula.")
    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    private Produto produto;

    @NotNull(message = "A entrada nao pode ser nula.")
    @ManyToOne
    @JoinColumn(name = "entrada_id", referencedColumnName = "id", nullable = false)
    private Entrada entrada;

    public EntradaItens() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntradaItens other = (EntradaItens) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

}
