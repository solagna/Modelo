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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Emanuele
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @EmbeddedId
    private VendaID id;
    @NotNull(message = "A data da compra deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorTotal;
    @NotBlank(message = "O tipo de pagamento deve ser informado")
    @Length(max = 25, message = "O tipo de pagamento deve ter até {max} caracteres")
    @Column(name = "pagamento", length = 25, nullable = false)
    private String pagamento;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VendaItens> itens = new ArrayList<>();

    public void adicionarItem(VendaItens obj) {
        obj.setVenda(this);
        this.valorTotal += obj.getTotal();
        this.itens.add(obj);
    }

    public void removerItem(int index) {
        VendaItens obj = this.itens.get(index);
        this.valorTotal -= obj.getTotal();
        this.itens.remove(obj);
    }

    public Venda() {
        this.valorTotal = 0.0;
    }

    public VendaID getId() {
        return id;
    }

    public void setId(VendaID id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public List<VendaItens> getItens() {
        return itens;
    }

    public void setItens(List<VendaItens> itens) {
        this.itens = itens;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
