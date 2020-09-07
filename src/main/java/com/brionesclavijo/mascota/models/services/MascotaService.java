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

import com.brionesclavijo.mascota.models.dao.IMascota;
import com.brionesclavijo.mascota.models.entities.Mascota;
import com.brionesclavijo.mascota.models.reporting.rptMascotasPorEdades;

@Service
public class MascotaService implements IMascotaService {
	
	@Autowired 
	private IMascota dao;
	
	@PersistenceContext
	private EntityManager em;
	
		
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
	
	@Override
	public List<rptMascotasPorEdades> _rptMascotasPorEdades() {		
		StoredProcedureQuery query = em.createStoredProcedureQuery("mascotas_edades");
		query.execute();
		List<Object[]> datos = query.getResultList();		
		return datos.stream()
				.map(r -> new rptMascotasPorEdades((String)r[0], (String)r[1], (int)r[2]))
				.collect(Collectors.toList());
			
	
	}
	
	
	
}