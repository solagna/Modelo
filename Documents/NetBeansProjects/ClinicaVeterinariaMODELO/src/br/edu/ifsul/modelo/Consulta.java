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
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Emanuele
 */
@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "A data da consulta deve ser informada.")
    @Temporal(TemporalType.DATE)
    private Calendar dataConsulta;

    @NotNull(message = "A data do pagamento deve ser informado.")
    @Temporal(TemporalType.DATE)
    private Calendar dataPagamento;

    @NotNull(message = "A data do agendamento deve ser informada.")
    @Temporal(TemporalType.DATE)
    private Calendar dataAgendamento;

    @Length(max = 30, message = "A descricao nao pode ter mais de {max} caracteres.")
    @Column(name = "descricao", nullable = false, length = 30)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = false)
    private Medico medico;

    @ManyToMany
    @JoinTable(name = "receita", joinColumns = @JoinColumn(name = "consulta", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento", referencedColumnName = "id"))
    private List<Medicamento> receita = new ArrayList<>();

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Calendar dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Calendar getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Calendar dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Medicamento> getReceita() {
        return receita;
    }

    public void setReceita(List<Medicamento> receita) {
        this.receita = receita;
    }

}
