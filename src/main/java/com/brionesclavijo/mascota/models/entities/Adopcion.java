package com.brionesclavijo.mascota.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name="adopciones")
public class Adopcion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_adopcion")
	private Integer idadopcion;
	
	@Column(name="fecha_publicacion")
	private LocalDateTime fechaPublicacion;
	
	@Column(name="fecha_asignacion")	
	private LocalDateTime fechaAsignacion;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="observacion")
	private String observacion;
	
	@Column(name="us_asignado")
	private String us_asignado;
	
	
	
	public Adopcion() {
		super();
	}
	
	public Adopcion(Integer id) {
		super();
		this.idadopcion = id;
	}

	public Integer getIdadopcion() {
		return idadopcion;
	}

	public void setIdadopcion(Integer idadopcion) {
		this.idadopcion = idadopcion;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public LocalDateTime getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	public String getUs_asignado() {
		return us_asignado;
	}

	public void setUs_asignado(String us_asignado) {
		this.us_asignado = us_asignado;
	}
	

	//Realacion de tablas
	@JoinColumn(name="fk_mascota", referencedColumnName="pk_mascota")
	@ManyToOne
	private Mascota mascota;
	
	/*@JoinColumn(name="fk_persona", referencedColumnName="pk_persona")
	@ManyToOne
	private Persona persona;*/

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	/*
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}*/

	@Override
	public String toString() {
		return estado;
	}
	
	public String fechaPublic() {
		if(fechaPublicacion==null) {
			return " ";
		}else {
		return (fechaPublicacion.getYear()+"/"+fechaPublicacion.getMonthValue()+"/"+fechaPublicacion.getDayOfMonth());
		}
	}
	public String fechaAsignac() {
		if(fechaAsignacion==null) {
			return " ";
		}else {
			return (fechaAsignacion.getYear()+"/"+fechaAsignacion.getMonthValue()+"/"+fechaAsignacion.getDayOfMonth());
		}
	}
	
	@PrePersist
	public void prePersist() {
		fechaPublicacion = LocalDateTime.now();
	}

	public void Actualizar() {
		fechaAsignacion = LocalDateTime.now();
		SecurityContext context = SecurityContextHolder.getContext();
		us_asignado = context.getAuthentication().getName();
        this.estado="RESERVADO";
        
	}

}
