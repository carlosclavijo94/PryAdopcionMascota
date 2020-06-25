package com.brionesclavijo.mascota.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  
@Table(name="mascotas")
public class Mascota implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_mascota")	
	private Integer idmascota;
	
	@Column(name="nombre")	
	private String nombre;
	
	@Column(name="edad")	
	private Integer edad;
	
	@Column(name="color")	
	private String color;
	
	@Column(name="tipo_mascota")	
	private String tipoMascota;
	
	
	@Column(name="raza")	
	private String raza;
	
	public Mascota() {
		super();
	}
	
	public Mascota(Integer id) {
		super();
		this.idmascota = id;
	}

	public Integer getIdmascota() {
		return idmascota;
	}

	public void setIdmascota(Integer idmascota) {
		this.idmascota = idmascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public String getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}
	
	//Relaciones entre tablas
	
	@OneToMany(mappedBy="mascota", fetch=FetchType.LAZY) 
	private List<CarnetVacunacion> lstcarnet;
	
	
	public List<CarnetVacunacion> getLstcarnet() {
		return lstcarnet;
	}

	public void setLstcarnet(List<CarnetVacunacion> lstcarnet) {
		this.lstcarnet = lstcarnet;
	}

	@OneToMany(mappedBy="mascota", fetch=FetchType.LAZY) 
	private List<Adopcion> lstadopcion;
	
	
	public List<Adopcion> getLstadopcion() {
		return lstadopcion;
	}

	public void setLstadopcion(List<Adopcion> lstadopcion) {
		this.lstadopcion = lstadopcion;
	}

	@Override
	public String toString() {
		return this.getNombre()+" "+ this.getTipoMascota();
	}
	

}
