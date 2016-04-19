/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;


import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "paciente")
public class Paciente extends Pessoa implements Serializable{

    @CPF
    @NotNull(message = "O CPF deve ser informado")
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(name = "cadastro", nullable = false)
    private Calendar cadastro = Calendar.getInstance();
    
    @NotNull(message = "O nascimento deve ser informado!")
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    
    @NotNull(message = "O RG deve ser informado")
    @NotBlank(message = "O RG nao pode ficar em branco!")
    @Length(max = 11, message = "O RG nao pode ter mais de {max} caracteres.")
    @Column(name = "RG", length = 11, nullable = false)
    private String rg;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getCadastro() {
        return cadastro;
    }

    public void setCadastro(Calendar cadastro) {
        this.cadastro = cadastro;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    

}
