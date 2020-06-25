package com.brionesclavijo.mascota.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="adopcion")
public class Adopcion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_adopcion")
	private Integer idadopcion;
	
	@Column(name="fecha_publicacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaPublicacion;
	
	@Column(name="fecha_asignacion")	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaAsignacion;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="observacion")
	private String observacion;
	
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

	public Calendar getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Calendar fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Calendar getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Calendar fechaAsignacion) {
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
	
	//Realacion de tablas
	
	@JoinColumn(name="fk_mascota", referencedColumnName="pk_mascota")
	@ManyToOne
	private Mascota mascota;
	
	
	@JoinColumn(name="fk_persona", referencedColumnName="pk_persona")
	@ManyToOne
	private Persona persona;

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return estado;
	}
	
	public String fechaPublic() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");		
		return sdf.format(fechaPublicacion.getTime());
	}
	public String fechaAsignacion() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");		
		return sdf.format(fechaAsignacion.getTime());
	}

}
