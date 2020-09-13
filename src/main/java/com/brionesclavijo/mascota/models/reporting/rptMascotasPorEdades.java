package com.brionesclavijo.mascota.models.reporting;

import java.io.Serializable;

public class rptMascotasPorEdades implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String tipo;
	private int edad;
	
	public rptMascotasPorEdades() {
		super();
	}
	
	public rptMascotasPorEdades(String nombre, String tipo, int edad) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	

}
