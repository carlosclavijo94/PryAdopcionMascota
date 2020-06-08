package com.brionesclavijo.mascota.models.entities;

import java.io.Serializable;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity  
@Table(name="vacunas")
public class Vacuna implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_vacuna")	
	private Integer idvacuna;
	
	@Column(name="nombre")	
	private String nombre;
	
	@Column(name="observacion")	
	private String observacion;
	
	public Vacuna() {
		super();
	}
	
	public Vacuna(Integer id) {
		super();
		this.idvacuna = id;
	}

	public Integer getIdvacuna() {
		return idvacuna;
	}

	public void setIdvacuna(Integer idvacuna) {
		this.idvacuna = idvacuna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	//Relaciones entre tablas
	

	@JoinColumn(name="fk_carnet", referencedColumnName="pk_carnetVacunacion")
	@ManyToOne
	private CarnetVacunacion carnet;
	

	public CarnetVacunacion getCarnet() {
		return carnet;
	}

	public void setCarnet(CarnetVacunacion carnet) {
		this.carnet = carnet;
	}
	
	@Override
	public String toString() {
		return this.getNombre();
	}


}
