package com.brionesclavijo.mascota.models.services;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brionesclavijo.mascota.models.dao.IAdopcion;
import com.brionesclavijo.mascota.models.entities.Adopcion;
import com.brionesclavijo.mascota.models.reporting.CltAdopcionMascotas;

@Service
public class AdopcionService implements IAdopcionService {
	
	@Autowired 
	private IAdopcion dao;
	
	@PersistenceContext
	private EntityManager em;
		
	
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
	@Override
	@Transactional
	public List<Adopcion> findByEstado(String estado) {		
		return dao.findByEstadoStartingWith(estado);
	}
	@Override
	public List<CltAdopcionMascotas> _cltAdopcionMascotas() {		
		StoredProcedureQuery query = em.createStoredProcedureQuery("adopcion_mascotas_disponibles");
		query.execute();
		List<Object[]> datos = query.getResultList();		
		return datos.stream()
				.map(r -> new CltAdopcionMascotas((BigInteger)r[0], (String)r[1],(String)r[2]))
				.collect(Collectors.toList());		
	}
}