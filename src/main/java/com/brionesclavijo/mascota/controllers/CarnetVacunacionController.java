package com.brionesclavijo.mascota.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brionesclavijo.mascota.models.entities.CarnetVacunacion;
import com.brionesclavijo.mascota.models.services.ICarnetVacunacionService;

@Controller
@RequestMapping(value="/carnet_vacunacion")  
public class CarnetVacunacionController {
	@Autowired 
	private ICarnetVacunacionService srvCarnetVacunacion;
	
	@GetMapping(value="/create") //https://localhost:8084/carnet_vacunacion/create
	public String create(Model model) {
		CarnetVacunacion carnetVacunacion = new CarnetVacunacion();
		model.addAttribute("title", "Registro de nuevo carnet_vacunacion");
		model.addAttribute("carnet_vacunacion", carnetVacunacion); 
		return "carnet_vacunacion/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		CarnetVacunacion carnetVacunacion = srvCarnetVacunacion.findById(id);
		model.addAttribute("carnet_vacunacion", carnetVacunacion);				
		return "carnet_vacunacion/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		CarnetVacunacion carnetVacunacion = srvCarnetVacunacion.findById(id);
		model.addAttribute("carnet_vacunacion", carnetVacunacion);
		model.addAttribute("title", "Actualizando el registro de " + carnetVacunacion);
		return "carnet_vacunacion/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvCarnetVacunacion.delete(id);
		return "redirect:/carnet_vacunacion/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<CarnetVacunacion> lstcarnetVacunaciones = srvCarnetVacunacion.findAll();
		model.addAttribute("lista de carnet_vacunaciones", lstcarnetVacunaciones);
		model.addAttribute("title", "Listado de carnet_vacunaciones");
		return "carnet_vacunacion/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(CarnetVacunacion carnetVacunacion, Model model) {
		srvCarnetVacunacion.save(carnetVacunacion);
		return "redirect:/carnet_vacunacion/list";
	}
}

