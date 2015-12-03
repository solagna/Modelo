package br.edu.ifsul.modelo;

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
@Table(name = "p_varejo")
public class PassageiroVarejo extends Passageiro {
    @NotNull(message = "O Numero do cartão deve ser informado")
    @NotBlank(message = "O Numero do cartão não pode ficar em branco")
    @Length(max = 20, message = "O Numero do cartão não pode ter mais de {max} caracteres")
    @Column(name = "cartao", length = 20, nullable = false)
    private String numeroCartao;
    @NotNull(message = "O tipo do cartão deve ser informado")
    @NotBlank(message = "O tipo do cartão não pode ficar em branco")
    @Length(max = 20, message = "O tipo do cartão não pode ter mais de {max} caracteres")
    @Column(name = "tipo_cartao", length = 20, nullable = false)
    private String tipoCartao;
    @NotNull(message = "A operadora do cartão deve ser informada.")
    @NotBlank(message = "A operadora do cartão não pode ficar em branco")
    @Length(max = 20, message = "A operadora do cartão não pode ter mais de {max} caracteres")
    @Column(name = "operadora_cartao", length = 20, nullable = false)
    private String operadoraCartao;

    public PassageiroVarejo() {
    }
  
        
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getOperadoraCartao() {
        return operadoraCartao;
    }

    public void setOperadoraCartao(String operadoraCartao) {
        this.operadoraCartao = operadoraCartao;
    }

}
