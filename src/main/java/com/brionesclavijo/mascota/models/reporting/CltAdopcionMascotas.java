package com.brionesclavijo.mascota.models.reporting;

import java.io.Serializable;
import java.math.BigInteger;

public class CltAdopcionMascotas implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigInteger id;
	private String mascota;
	private String imagen;

	
	public CltAdopcionMascotas(BigInteger id, String mascota, String imagen) {
		super();
		this.id = id;
		this.mascota = mascota;
		this.imagen = imagen;
	}

	public CltAdopcionMascotas() {
		super();
	}

	public String getMascota() {
		return mascota;
	}

	public void setMascota(String mascota) {
		this.mascota = mascota;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	
}
