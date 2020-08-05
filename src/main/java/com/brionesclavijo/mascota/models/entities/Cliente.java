package com.brionesclavijo.mascota.models.entities;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente extends Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "pk_cliente")
	private Integer idcliente;
	
	
	@Column(name="codigo")
	@NotEmpty
	@Size(max=10)
	private String codigo;
	
	public Cliente() {
		super();
	}
	
	public Cliente(Integer id) {
		super();
		this.idcliente = id;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY)
	private List<Adopcion> adopciones;
	
	
	public List<Adopcion> getAdopciones() {
		return adopciones;
	}

	public void setAdopciones(List<Adopcion> adopciones) {
		this.adopciones = adopciones;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
