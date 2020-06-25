package com.brionesclavijo.mascota.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaVacunacion;
	
	@Column(name="observacion")	
	private String observacion;
	
	
	
	public Calendar getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Calendar fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");		
		return sdf.format(fechaVacunacion.getTime());
	}

	@Override
	public String toString() {
		return vacuna.getNombre();
	}
	
	
	
}
