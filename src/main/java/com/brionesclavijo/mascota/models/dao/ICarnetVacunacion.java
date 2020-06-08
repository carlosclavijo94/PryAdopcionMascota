package com.brionesclavijo.mascota.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.brionesclavijo.mascota.models.entities.CarnetVacunacion;

public interface ICarnetVacunacion extends CrudRepository<CarnetVacunacion, Integer> {
}
