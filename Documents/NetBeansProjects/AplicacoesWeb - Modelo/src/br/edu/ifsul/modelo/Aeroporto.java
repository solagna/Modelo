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

@Entity
@Table(name = "aeroporto")
public class Aeroporto implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_aeroporto", sequenceName = "seq_aeroporto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aeroporto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome deve ser informado.")
    @NotNull(message = "O nome nao pode ser nulo.")
    @Length(max = 50, message = "O nome nao pode ter mais de {max} caracteres.")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotBlank(message = "A cidade deve ser informada.")
    @NotNull(message = "O cidade não pode ser nula.")
    @Length(max = 30, message = "A cidade não pode ter mais de {max} caracteres.")
    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;
    @NotBlank(message = "O estado deve ser informado.")
    @NotNull(message = "O estado não pode ser nulo.")
    @Length(max = 3, message = "O estado nao pode ter mais de {max} caracteres.")
    @Column(name = "estado", length = 50, nullable = false)
    private String estado;
    @NotBlank(message = "O endereço deve ser informado.")
    @NotNull(message = "O endereço não pode ser nulo.")
    @Length(max = 50, message = "O nome nao pode ter mais de {max} caracteres.")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
   @ManyToMany
   @JoinTable(name = "escalas",
           joinColumns = 
                   @JoinColumn(name = "aeroporto", referencedColumnName = "id"),
            inverseJoinColumns = 
                   @JoinColumn(name = "voo", referencedColumnName = "id"))
    private List<Voo> escalas = new ArrayList<>();

    public Aeroporto() {

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Aeroporto other = (Aeroporto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public List<Voo> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Voo> escalas) {
        this.escalas = escalas;
    }


}
