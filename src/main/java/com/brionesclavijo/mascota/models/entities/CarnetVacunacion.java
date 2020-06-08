package com.brionesclavijo.mascota.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
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
	private Calendar fechaVacunacion;
	
	@Column(name="observacion")	
	private String observacion;
	
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
	
	//Relaciones entre tablas
	
	@OneToMany(mappedBy="carnet", fetch=FetchType.LAZY) 
	private List<Vacuna> lstvacuna;	
	
	
	
	public List<Vacuna> getLstvacuna() {
		return lstvacuna;
	}

	public void setLstvacuna(List<Vacuna> lstvacuna) {
		this.lstvacuna = lstvacuna;
	}

	@JoinColumn(name="fk_mascota", referencedColumnName="pk_mascota")
	@ManyToOne
	private Mascota mascota;

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	
	
}
