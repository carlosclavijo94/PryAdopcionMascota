package com.brionesclavijo.mascota.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.brionesclavijo.mascota.models.entities.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer> {
}
