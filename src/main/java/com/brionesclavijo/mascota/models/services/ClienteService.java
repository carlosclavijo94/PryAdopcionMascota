package com.brionesclavijo.mascota.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brionesclavijo.mascota.models.dao.ICliente;
import com.brionesclavijo.mascota.models.entities.Cliente;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired 
	private ICliente dao;
		
	@Override
	@Transactional
	public void save(Cliente c) {
		dao.save(c);		
	}

	@Override
	@Transactional
	public Cliente findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Cliente> findAll() {		
		return (List<Cliente>) dao.findAll();
	}
}