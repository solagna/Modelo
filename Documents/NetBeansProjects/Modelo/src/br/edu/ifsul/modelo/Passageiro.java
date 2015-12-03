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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Emanuele
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "passageiro")
public abstract class Passageiro implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_passageiro", sequenceName = "seq_passageiro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_passageiro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome deve ser informado.")
    @NotBlank(message = "O nome não pode ficar em branco.")
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres.")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "O endereço deve ser informado.")
    @NotBlank(message = "O endereço não pode ficar em branco.")
    @Length(max = 30, message = "O endereço não pode ter mais de {max} caracteres.")
    @Column(name = "endereco", length = 30, nullable = false)
    private String endereco;
    @NotNull(message = "O cep deve ser informado")
    @NotBlank(message = "O cep não pode ficar em branco")
    @Length(max = 9, message = "O cep não pode ter mais de {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    @Email(message = "O email deve ser válido.")
    @NotNull(message = "O email deve ser informado.")
    @NotBlank(message = "O email não pode ficar em branco.")
    @Length(max = 50, message = "O email não pode ter mais de {max} caracteres.")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @NotNull(message = "A data deve ser informada.")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar dataNascimento;
    @OneToMany(mappedBy = "passageiro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();
   

    public Passageiro() {
    }

     public void adicionarReserva(Reserva obj) {
        obj.setPassageiro(this);
        this.reservas.add(obj);
    }
    
    public void removerReserva(int index) {
        this.reservas.remove(index);
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

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Passageiro other = (Passageiro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

  

}
