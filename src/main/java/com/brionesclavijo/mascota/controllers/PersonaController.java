package com.brionesclavijo.mascota.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brionesclavijo.mascota.models.entities.Persona;
import com.brionesclavijo.mascota.models.services.IPersonaService;


@Controller
@RequestMapping(value="/persona")  
public class PersonaController {
	@Autowired 
	private IPersonaService srvPersona;
	
	
	@GetMapping(value="/create") //https://localhost:8084/persona/create
	public String create(Model model) {
		Persona persona = new Persona();
		model.addAttribute("title", "Registro de nuevo persona");
		model.addAttribute("persona", persona); 
		return "persona/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Persona persona = srvPersona.findById(id);
		model.addAttribute("persona", persona);				
		return "persona/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Persona persona = srvPersona.findById(id);
		model.addAttribute("persona", persona);
		model.addAttribute("title", "Actualizando el registro de " + persona);
		return "persona/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvPersona.delete(id);
		return "redirect:/persona/list";		
	}
	
	@GetMapping(value={"","/","/list"})
	public String list(Model model) {
		List<Persona> personas = srvPersona.findAll();
		model.addAttribute("personas", personas);
		model.addAttribute("title", "Listado de personas");
		return "persona/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(Persona persona, Model model) {
		srvPersona.save(persona);
		return "redirect:/persona/list";
	}
}
