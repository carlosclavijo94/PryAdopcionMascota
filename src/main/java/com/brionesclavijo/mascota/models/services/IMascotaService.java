package com.brionesclavijo.mascota.models.services;

import java.util.List;

import com.brionesclavijo.mascota.models.entities.Mascota;
import com.brionesclavijo.mascota.models.reporting.rptMascotasPorEdades;

public interface IMascotaService {
	public void save(Mascota m);
	public Mascota findById(Integer id);
	public void delete(Integer id);
	public List<Mascota> findAll();
	public List<rptMascotasPorEdades> _rptMascotasPorEdades();
	
}
