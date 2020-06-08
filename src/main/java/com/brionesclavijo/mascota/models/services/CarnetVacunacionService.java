package com.brionesclavijo.mascota.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brionesclavijo.mascota.models.dao.ICarnetVacunacion;
import com.brionesclavijo.mascota.models.entities.CarnetVacunacion;

@Service
public class CarnetVacunacionService implements ICarnetVacunacionService {
	
	@Autowired 
	private ICarnetVacunacion dao;
		
	@Override
	@Transactional
	public void save(CarnetVacunacion c) {
		dao.save(c);		
	}

	@Override
	@Transactional
	public CarnetVacunacion findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<CarnetVacunacion> findAll() {		
		return (List<CarnetVacunacion>) dao.findAll();
	}
}