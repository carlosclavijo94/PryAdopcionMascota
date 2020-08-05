package com.brionesclavijo.mascota.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.brionesclavijo.mascota.models.entities.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer> {
	
}
