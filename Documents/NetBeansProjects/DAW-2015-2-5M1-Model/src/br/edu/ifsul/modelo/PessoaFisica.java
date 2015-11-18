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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Emanuele
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {

    @NotNull(message = "O RG deve ser informado")
    @NotBlank(message = "O RG nao pode ficar em branco!")
    @Length(max = 11, message = "O RG nao pode ter mais de {max} caracteres.")
    @Column(name = "RG", length = 11, nullable = false)
    private String rg;
    @CPF(message = "O CPF deve ser valido!")
    @NotNull(message = "O CPF deve ser informado!")
    @NotBlank(message = "O CPF nao pode ficar em branco!")
    @Length(max = 14, message = "O CPF nao pode ter mais de {max} caracteres.")
    private String cpf;
    @NotNull(message = "O nascimento deve ser informado!")
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    @ManyToMany
    @JoinTable (name = "desejos", joinColumns = @JoinColumn(name = "pessoa", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "produto", referencedColumnName = "id"))
    private List<Produto> desejos = new ArrayList<>();
    
    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public List<Produto> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<Produto> desejos) {
        this.desejos = desejos;
    }


}