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

import com.brionesclavijo.mascota.models.dao.ICarnetVacunacion;
import com.brionesclavijo.mascota.models.entities.CarnetVacunacion;
import com.brionesclavijo.mascota.models.entities.Mascota;
import com.brionesclavijo.mascota.models.reporting.rptVacunasPorMascotas;

import ch.qos.logback.classic.Logger;

@Service
public class CarnetVacunacionService implements ICarnetVacunacionService {
	
	@Autowired 
	private ICarnetVacunacion dao;
	
	@PersistenceContext
	private EntityManager em;
		
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
	
	@Override
	@Transactional
	public List<CarnetVacunacion> findByMascota(Mascota m) {	
		try {
		List<CarnetVacunacion> resultado=dao.findByMascota(m.getIdmascota());
		return resultado;
		}
		catch(Exception ex){
			System.out.println("error->"+ex.getMessage());
			return null;
		}

	}
	
	@Override
	public List<rptVacunasPorMascotas> _rptVacunasPorMascotas() {		
		StoredProcedureQuery query = em.createStoredProcedureQuery("vacunas_por_mascotas");
		query.execute();
		List<Object[]> datos = query.getResultList();		
		return datos.stream()
				.map(r -> new rptVacunasPorMascotas((String)r[0], (BigInteger)r[1], (Double)r[2]))
				.collect(Collectors.toList());		
	}
	
}