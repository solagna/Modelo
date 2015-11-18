/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author Emanuele
 */
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable{
    @CNPJ
    @NotNull(message = "O CNPJ deve ser informado")
    @NotBlank(message = "O CNPJ nao pode ficar em branco!")
    @Length(max = 20, message = "O CNPJ nao pode ter mais de {max} caracteres.")
    @Column(name = "CNPJ", length = 20 , nullable = false)
    private String cnpj;
    
    @NotNull(message = "O IE deve ser informado")
    @NotBlank(message = "O IE nao pode ficar em branco!")
    @Length(max = 30, message = "O IE nao pode ter mais de {max} caracteres.")
    @Column(name = "IE", length = 30, nullable = false)
    private String ie;

    public PessoaJuridica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
    
     
}
