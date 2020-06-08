package com.brionesclavijo.mascota.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brionesclavijo.mascota.models.dao.IMascota;
import com.brionesclavijo.mascota.models.entities.Mascota;

@Service
public class MascotaService implements IMascotaService {
	
	@Autowired 
	private IMascota dao;
		
	@Override
	@Transactional
	public void save(Mascota m) {
		dao.save(m);		
	}

	@Override
	@Transactional
	public Mascota findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Mascota> findAll() {		
		return (List<Mascota>) dao.findAll();
	}
}