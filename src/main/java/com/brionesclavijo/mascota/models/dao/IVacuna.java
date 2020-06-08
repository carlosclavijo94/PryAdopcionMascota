package com.brionesclavijo.mascota.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.brionesclavijo.mascota.models.entities.Vacuna;

public interface IVacuna extends CrudRepository<Vacuna, Integer> {
}
