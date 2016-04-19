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
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Emanuele
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class Pessoa implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Email(message = "O email deve ser válido")
    @NotBlank(message = "O Email deve ser informado")
    @Length(max = 50,message = "O Email não deve ter mais de {max} caracteres")
    @Column(name = "email", length = 50, nullable = false, unique = true)      
    private String email;
    @NotBlank(message = "A cidade deve ser informada.")
    @Length(max = 50, message = "A cidade não deve ter mais de {max} caracteres")
    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;
    @NotBlank(message = "O endereço deve ser informado")
    @Length(max = 50, message = "O endereço não deve ter mais de {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>(); //atributo da outra classe

    public Pessoa() {
    }
    
    public void adicionarTelefone(Telefone obj) {
        obj.setPessoa(this);
        this.telefones.add(obj);
    }
    public void removerTelefone(int index){
        this.telefones.remove(id);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return  nome;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
