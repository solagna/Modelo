package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "voo")
public class Voo implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_voo", sequenceName = "seq_voo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_voo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;
    @NotNull(message = "O status deve ser informado")
    @NotBlank(message = "O status deve ser informado")
    @NotEmpty(message = "O status deve ser informado")
    @Column(name = "status", length = 50, nullable = false)
    private String status;
    @ManyToMany
    @JoinTable(name = "escalas", joinColumns = @JoinColumn(name = "voo", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "aeroporto", referencedColumnName = "id"))
    private List<Aeroporto> escalas = new ArrayList<>();

    @OneToMany(mappedBy = "voo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Assento> assentos = new ArrayList<>();

    public Voo() {
    }

    public void adicionarAssentos(Assento obj) {
        obj.setVoo(this);
        this.assentos.add(obj);
    }

    public void removerAssentos(int index) {
        this.assentos.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Voo other = (Voo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }

    public List<Aeroporto> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Aeroporto> escalas) {
        this.escalas = escalas;
    }

    @Override
    public String toString() {
 
        Calendar c = data;
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String a = s.format(c);
        return "Voo{" + "ID :" + id + ", Data:" + c + "}";

    }
}
