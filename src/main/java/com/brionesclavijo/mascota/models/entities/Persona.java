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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_persona")
	private Integer idpersona;
	
	@Column(name="cedula")
	private String cedula;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	public Persona() {
		super();
		usuario=new Usuario();
	}
	
	public Persona(Integer id) {
		super();
		this.idpersona = id;
	}
		
	
	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	//Relacion con la tabla
	
	@JoinColumn(name="usuario_id",unique=true)
	@OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY) 
	private List<Adopcion> lstadopcion;
	
	public List<Adopcion> getLstadopcion() {
		return lstadopcion;
	}

	public void setLstadopcion(List<Adopcion> lstadopcion) {
		this.lstadopcion = lstadopcion;
	}

	@Override
	public String toString() {
		return cedula+ " - " +nombre ;
	}
	
	


}

