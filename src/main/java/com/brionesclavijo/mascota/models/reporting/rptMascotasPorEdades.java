package com.brionesclavijo.mascota.models.reporting;

import java.io.Serializable;

public class rptMascotasPorEdades implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String perro;
	private int edad;
	
	public rptMascotasPorEdades(String nombre, String perro, int edad) {
		super();
		this.nombre = nombre;
		this.perro = perro;
		this.edad = edad;
	}
	
	public rptMascotasPorEdades() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPerro() {
		return perro;
	}

	public void setPerro(String perro) {
		this.perro = perro;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	
	

}
