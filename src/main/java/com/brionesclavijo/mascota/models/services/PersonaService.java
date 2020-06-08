package com.brionesclavijo.mascota.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brionesclavijo.mascota.models.dao.IPersona;
import com.brionesclavijo.mascota.models.entities.Persona;

@Service
public class PersonaService implements IPersonaService {
	
	@Autowired 
	private IPersona dao;
		
	@Override
	@Transactional
	public void save(Persona p) {
		dao.save(p);		
	}

	@Override
	@Transactional
	public Persona findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Persona> findAll() {		
		return (List<Persona>) dao.findAll();
	}
}