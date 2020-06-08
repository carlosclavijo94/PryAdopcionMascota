package com.brionesclavijo.mascota.models.services;

import java.util.List;

import com.brionesclavijo.mascota.models.entities.Mascota;

public interface IMascotaService {
	public void save(Mascota m);
	public Mascota findById(Integer id);
	public void delete(Integer id);
	public List<Mascota> findAll();
}
