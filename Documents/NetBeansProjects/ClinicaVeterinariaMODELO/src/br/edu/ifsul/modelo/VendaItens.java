/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author Emanuele
 */
@Entity
@Table(name = "venda_itens")
public class VendaItens implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_itens", sequenceName = "seq_itens_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_itens", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "A quantidade deve ser informada.")
    @Column(name = "quantidade", nullable = false, columnDefinition = "decimal(12,2)")
    @Range(min = 0)
    private Double quantidade;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(10,2)")
    private Double total;

    @ManyToOne
    @NotNull(message = "A venda deve ser informada")
    private Venda venda;

    @ManyToOne
    @NotNull(message = "O produto deve ser informado")
    @JoinColumn(name = "medicamento", referencedColumnName = "id", nullable = false)
    private Medicamento medicamento;

    public VendaItens() {
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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
