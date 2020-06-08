package com.brionesclavijo.mascota.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brionesclavijo.mascota.models.entities.Vacuna;
import com.brionesclavijo.mascota.models.services.IVacunaService;

@Controller
@RequestMapping(value="/vacuna")  
public class VacunaController {
	@Autowired 
	private IVacunaService srvVacuna;
	
	@GetMapping(value="/create") //https://localhost:8084/vacuna/create
	public String create(Model model) {
		Vacuna vacuna = new Vacuna();
		model.addAttribute("title", "Registro de nueva vacuna");
		model.addAttribute("vacuna", vacuna); 
		return "vacuna/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Vacuna vacuna = srvVacuna.findById(id);
		model.addAttribute("vacuna", vacuna);				
		return "vacuna/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Vacuna vacuna = srvVacuna.findById(id);
		model.addAttribute("vacuna", vacuna);
		model.addAttribute("title", "Actualizando el registro de " + vacuna);
		return "vacuna/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvVacuna.delete(id);
		return "redirect:/vacuna/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Vacuna> vacunas = srvVacuna.findAll();
		model.addAttribute("vacunas", vacunas);
		model.addAttribute("title", "Listado de vacunas");
		return "vacuna/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(Vacuna vacuna, Model model) {
		srvVacuna.save(vacuna);
		return "redirect:/vacuna/list";
	}
}

