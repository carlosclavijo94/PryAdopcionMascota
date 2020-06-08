package com.brionesclavijo.mascota.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brionesclavijo.mascota.models.dao.IUsuario;
import com.brionesclavijo.mascota.models.entities.Usuario;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired 
	private IUsuario dao;
		
	@Override
	@Transactional
	public void save(Usuario u) {
		dao.save(u);		
	}

	@Override
	@Transactional
	public Usuario findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Usuario> findAll() {		
		return (List<Usuario>) dao.findAll();
	}
}