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
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Emanuele
 */
@Entity
@Table(name = "medico")
public class Medico extends Pessoa implements Serializable {
    
    @NotNull(message = "O CRM deve ser informado.")
    @Column(name = "crm", length = 5, nullable = false)
    private Integer crm;
    
    @NotEmpty(message = "A Especialidade deve ser informado.")
    @Length(max = 25, min = 3, message = "A Especialidade deve ter no minimo {min} e no maximo {max}  caracteres")
    @Column(name = "especialidade", length = 25, nullable = false)
    private String especialidade;
    
    @NotNull(message = "A carga horária deve ser informada.")
    @Column(name = "carga_horaria", length = 3, nullable = false)
    private Double cargaHoraria;

    @NotBlank(message = "O dia de folga deve ser informado.")
    @Length(max = 25, min = 5, message = "O dia de folga deve ter no minimo {min} e no maximo {max} caracteres")
    @Column(name = "folga", length = 25, nullable = false)
    private String folga;

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getFolga() {
        return folga;
    }

    public void setFolga(String folga) {
        this.folga = folga;
    }
    


}
