package com.brionesclavijo.mascota.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.brionesclavijo.mascota.models.entities.Persona;

public interface IPersona extends CrudRepository<Persona, Integer> {
}
