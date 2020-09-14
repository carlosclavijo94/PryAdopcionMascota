package com.brionesclavijo.mascota.models.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class rptVacunasPorMesTipoMascota implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer fecha;
	private String mes;
	private BigInteger perro;
	private BigInteger gato;

	

	public rptVacunasPorMesTipoMascota(Integer fecha, String mes, BigInteger perro, BigInteger gato) {
		super();
		this.fecha = fecha;
		this.mes = mes;
		this.perro = perro;
		this.gato = gato;
	}



	public rptVacunasPorMesTipoMascota() {
		super();
	}



	public Integer getFecha() {
		return fecha;
	}



	public void setFecha(Integer fecha) {
		this.fecha = fecha;
	}



	public String getMes() {
		return mes;
	}



	public void setMes(String mes) {
		this.mes = mes;
	}



	public BigInteger getPerro() {
		return perro;
	}



	public void setPerro(BigInteger perro) {
		this.perro = perro;
	}



	public BigInteger getGato() {
		return gato;
	}



	public void setGato(BigInteger gato) {
		this.gato = gato;
	}

	
	
}
