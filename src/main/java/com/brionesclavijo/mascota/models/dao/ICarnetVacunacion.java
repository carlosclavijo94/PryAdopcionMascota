package com.brionesclavijo.mascota.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.brionesclavijo.mascota.models.entities.CarnetVacunacion;

public interface ICarnetVacunacion extends CrudRepository<CarnetVacunacion, Integer> {
	
	
	@Query("SELECT C FROM CarnetVacunacion C WHERE C.mascota.idmascota = :id")
	public List<CarnetVacunacion> findByMascota(Integer id);
	
}
