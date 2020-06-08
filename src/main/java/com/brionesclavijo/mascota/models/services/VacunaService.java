package com.brionesclavijo.mascota.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brionesclavijo.mascota.models.dao.IVacuna;
import com.brionesclavijo.mascota.models.entities.Vacuna;

@Service
public class VacunaService implements IVacunaService {
	
	@Autowired 
	private IVacuna dao;
		
	@Override
	@Transactional
	public void save(Vacuna v) {
		dao.save(v);		
	}

	@Override
	@Transactional
	public Vacuna findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Vacuna> findAll() {		
		return (List<Vacuna>) dao.findAll();
	}
}