package com.brionesclavijo.mascota.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.brionesclavijo.mascota.models.entities.Mascota;

public interface IMascota extends CrudRepository<Mascota, Integer> {
}

