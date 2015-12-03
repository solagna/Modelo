package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "p_corporativo")
public class PassageiroCorporativo extends Passageiro implements Serializable {

    @NotNull(message = "O nome da empresa deve ser informado")
    @NotBlank(message = "O nome da empresa não pode ficar em branco")
    @Length(max = 20, message = "O nome da empresa não pode ter mais de {max} caracteres")
    @Column(name = "nome_empresa", length = 20, nullable = false)
    private String nomeEmpresa;
    @NotNull(message = "O numero da conta deve ser informado")
    @NotBlank(message = "O numero da conta não pode ficar em branco")
    @Length(max = 20, message = "O numero da conta não pode ter mais de {max} caracteres")
    @Column(name = "numero_conta", length = 20, nullable = false)
    private String numeroConta;
    @NotNull(message = "Os pontos devem ser informados")
    private Integer pontosVoo;

    public PassageiroCorporativo() {
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Integer getPontosVoo() {
        return pontosVoo;
    }

    public void setPontosVoo(Integer pontosVoo) {
        this.pontosVoo = pontosVoo;
    }

}
