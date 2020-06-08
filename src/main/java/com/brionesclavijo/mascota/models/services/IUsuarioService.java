package com.brionesclavijo.mascota.models.services;

import java.util.List;

import com.brionesclavijo.mascota.models.entities.Usuario;

public interface IUsuarioService {
	public void save(Usuario u);
	public Usuario findById(Integer id);
	public void delete(Integer id);
	public List<Usuario> findAll();
}
