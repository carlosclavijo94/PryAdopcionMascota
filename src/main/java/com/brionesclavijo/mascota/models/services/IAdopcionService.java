package com.brionesclavijo.mascota.models.services;

import java.util.List;

import com.brionesclavijo.mascota.models.entities.Adopcion;
import com.brionesclavijo.mascota.models.reporting.CltAdopcionMascotas;

public interface IAdopcionService {
	public void save(Adopcion a);
	public Adopcion findById(Integer id);
	public void delete(Integer id);
	public List<Adopcion> findAll();
	public List<Adopcion> findByEstado(String estado);
	public List<CltAdopcionMascotas> _cltAdopcionMascotas();
	
}
