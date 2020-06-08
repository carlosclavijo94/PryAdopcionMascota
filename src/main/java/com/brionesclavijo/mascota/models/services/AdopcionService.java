package com.brionesclavijo.mascota.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brionesclavijo.mascota.models.dao.IAdopcion;
import com.brionesclavijo.mascota.models.entities.Adopcion;

@Service
public class AdopcionService implements IAdopcionService {
	
	@Autowired 
	private IAdopcion dao;
		
	@Override
	@Transactional
	public void save(Adopcion a) {
		dao.save(a);		
	}

	@Override
	@Transactional
	public Adopcion findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Adopcion> findAll() {		
		return (List<Adopcion>) dao.findAll();
	}
}