package com.brionesclavijo.mascota.models.services;

import java.util.List;

import com.brionesclavijo.mascota.models.entities.CarnetVacunacion;

public interface ICarnetVacunacionService {
	public void save(CarnetVacunacion c);
	public CarnetVacunacion findById(Integer id);
	public void delete(Integer id);
	public List<CarnetVacunacion> findAll();
}
