package com.brionesclavijo.mascota.models.services;

import java.util.List;

import com.brionesclavijo.mascota.models.entities.Vacuna;

public interface IVacunaService {
	public void save(Vacuna v);
	public Vacuna findById(Integer id);
	public void delete(Integer id);
	public List<Vacuna> findAll();
}
