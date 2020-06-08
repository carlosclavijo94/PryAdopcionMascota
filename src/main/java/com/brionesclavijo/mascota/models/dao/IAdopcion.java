package com.brionesclavijo.mascota.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.brionesclavijo.mascota.models.entities.Adopcion;

public interface IAdopcion extends CrudRepository<Adopcion, Integer> {
}
