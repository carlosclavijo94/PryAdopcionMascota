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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity  
@Table(name="carnet_vacunacion")
public class CarnetVacunacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_carnetVacunacion")	
	private Integer idcarnetVacunacion;
	
	@Column(name="fecha_vacunacion")
	private LocalDateTime fechaVacunacion;
	
	@Column(name="costo")	
	private Float costo;
	
	public LocalDateTime getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(LocalDateTime fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public CarnetVacunacion() {
		super();
	}
	
	public CarnetVacunacion(Integer id) {
		super();
		this.idcarnetVacunacion = id;
	}

	public Integer getIdcarnetVacunacion() {
		return idcarnetVacunacion;
	}

	public void setIdcarnetVacunacion(Integer idcarnetVacunacion) {
		this.idcarnetVacunacion = idcarnetVacunacion;
	}
	
	//Relaciones entre tablas
	@JoinColumn(name="fk_mascota", referencedColumnName="pk_mascota")
	@ManyToOne
	private Mascota mascota;
	
	
	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	@JoinColumn(name="fk_vacuna", referencedColumnName="pk_vacuna")
	@ManyToOne
	private Vacuna vacuna;
	
	
	public String fechaVacuna() {
			
		return (fechaVacunacion.getYear()+"/"+fechaVacunacion.getMonthValue()+"/"+fechaVacunacion.getDayOfMonth());
	}

	@Override
	public String toString() {
		return vacuna.getNombre();
	}
	
	@PrePersist
	public void prePersist() {
		this.fechaVacunacion = LocalDateTime.now();
		//SecurityContext context = SecurityContextHolder.getContext();
        //creadoPor = context.getAuthentication().getName();
	}
	
}
