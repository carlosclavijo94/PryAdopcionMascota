package com.brionesclavijo.mascota.models.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class rptVacunasPorMascotas implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mascota;
	private BigInteger vacunas_realizadas;
	private Double total;

	public rptVacunasPorMascotas(String mascota, BigInteger vacunas_realizadas, Double total) {
		super();
		this.mascota = mascota;
		this.vacunas_realizadas = vacunas_realizadas;
		this.total = total;
	}

	public rptVacunasPorMascotas() {
		super();
	}

	public String getMascota() {
		return mascota;
	}

	public void setMascota(String mascota) {
		this.mascota = mascota;
	}

	public BigInteger getVacunas_realizadas() {
		return vacunas_realizadas;
	}

	public void setVacunas_realizadas(BigInteger vacunas_realizadas) {
		this.vacunas_realizadas = vacunas_realizadas;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
