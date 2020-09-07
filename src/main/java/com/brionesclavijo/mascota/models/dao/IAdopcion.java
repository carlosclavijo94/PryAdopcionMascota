package com.brionesclavijo.mascota.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brionesclavijo.mascota.models.entities.Adopcion;

public interface IAdopcion extends CrudRepository<Adopcion, Integer> {
	
	public List<Adopcion> findByEstadoStartingWith(String estado);
}
