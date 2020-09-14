package com.brionesclavijo.mascota.models.services;

import java.math.BigInteger;
import java.util.ArrayList;
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
import com.brionesclavijo.mascota.models.reporting.rptVacunasPorMesTipoMascota;

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
	@Override
	public List<rptVacunasPorMesTipoMascota> _rptVacunasPorMesTipoMascota() {		
		StoredProcedureQuery query = em.createStoredProcedureQuery("vacunas_por_tipo_mascota_perros");
		query.execute();
		List<Object[]> datos = query.getResultList();
		
		StoredProcedureQuery query2 = em.createStoredProcedureQuery("vacunas_por_tipo_mascota_gatos");
		query2.execute();
		List<Object[]> datos2 = query2.getResultList();
		int i,j;
		BigInteger aux;
		List<rptVacunasPorMesTipoMascota> result = new ArrayList<rptVacunasPorMesTipoMascota>();
		try {
			if((Integer)datos.get(0)[0]<=(Integer)datos2.get(0)[0]) {
				for(i=0;i<datos.size();i++) {
					rptVacunasPorMesTipoMascota rpt = new rptVacunasPorMesTipoMascota();
					aux=BigInteger.valueOf(0);
					for(j=0;j<datos2.size();j++) {
						if(datos.get(i)[0]==datos2.get(j)[0]) {
							aux=(BigInteger) datos2.get(j)[2];
						}
					}
					rpt.setFecha((Integer)datos.get(i)[0]);
					rpt.setMes((String)datos.get(i)[1]);
					rpt.setPerro((BigInteger)datos.get(i)[2]);
					rpt.setGato(aux);
					result.add(rpt);
				}
			}else {
				for(i=0;i<datos2.size();i++) {
					rptVacunasPorMesTipoMascota rpt = new rptVacunasPorMesTipoMascota();
					aux=BigInteger.valueOf(0);
					for(j=0;j<datos.size();j++) {
						if(datos2.get(i)[0]==datos.get(j)[0]) {
							aux=(BigInteger) datos.get(j)[1];
						}
					}
					rpt.setFecha((Integer)datos2.get(i)[0]);
					rpt.setMes((String)datos2.get(i)[1]);
					rpt.setGato((BigInteger)datos2.get(i)[2]);
					rpt.setPerro(aux);
					result.add(rpt);
				}
			}
			
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
		
		return result;	
	}
}