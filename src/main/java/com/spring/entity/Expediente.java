/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Benjam�n
 */
@Entity
@Table(name="EXPEDIENTE"
    ,schema="TOOUSER"
)
public class Expediente  implements java.io.Serializable {
    

     private BigDecimal codExpediente;
     private Clinica clinica;
     private Paciente paciente;
     private Date fechaCreacion;

    public Expediente() {
    }

    
    public Expediente(BigDecimal codExpediente, Clinica clinica, Paciente paciente, Date fechaCreacion) {
       this.codExpediente = codExpediente;
       this.clinica = clinica;
       this.paciente = paciente;
       this.fechaCreacion = fechaCreacion;
    }

    @Id 
    @Column(name="COD_EXPEDIENTE", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getCodExpediente() {
        return this.codExpediente;
    }
    
    public void setCodExpediente(BigDecimal codExpediente) {
        this.codExpediente = codExpediente;
    }

@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name="COD_CLINICA")
    public Clinica getClinica() {
        return this.clinica;
    }
    
    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ID_AFILIADO", nullable=false)
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_CREACION", nullable=false, length=7)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
