/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Emanuele
 */
@Embeddable
public class VendaID implements Serializable{
    @NotNull(message = "O numero da nota deve ser informada")
    @Column(name = "numero_nota", nullable = false)
    private Integer numeroNota;
    @NotNull(message = "O Paciente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;

     public VendaID() {
    }
    
    public Integer getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.numeroNota);
        hash = 79 * hash + Objects.hashCode(this.paciente);
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
        final VendaID other = (VendaID) obj;
        if (!Objects.equals(this.numeroNota, other.numeroNota)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return true;
    }

   
     
    
    
}
