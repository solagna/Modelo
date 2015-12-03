package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    @Id
    @Column(name = "numero")
    @SequenceGenerator(name = "seq_reserva", sequenceName = "seq_reserva_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_reserva", strategy = GenerationType.SEQUENCE)
    private Integer numero;
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @Temporal(TemporalType.DATE)
    @Column(name = "validade", nullable = false)
    private Calendar validade;
    @OneToOne
    @JoinColumn(name = "assento", referencedColumnName = "id", nullable = false)
    private Assento assento;
    @ManyToOne
    @JoinColumn(name = "passageiro_id", referencedColumnName = "id", nullable = false)
    private Passageiro passageiro;

    public Reserva() {

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Calendar getValidade() {
//        DecimalFormat fr = new DecimalFormat("dd/MM/aaaa");
//
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 7);
//        fr.format(c);
//        return c;
        
        return validade;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.numero);
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
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    public Calendar geraValidade() {

        DecimalFormat fr = new DecimalFormat("dd/MM/aaaa");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 10);
        fr.format(c);
        return c;

    }

}
