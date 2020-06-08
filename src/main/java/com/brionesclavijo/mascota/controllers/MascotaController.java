package com.brionesclavijo.mascota.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brionesclavijo.mascota.models.entities.Mascota;
import com.brionesclavijo.mascota.models.services.IMascotaService;

@Controller
@RequestMapping(value="/mascota")  
public class MascotaController {
	@Autowired 
	private IMascotaService srvMascota;
	
	@GetMapping(value="/create") //https://localhost:8084/mascota/create
	public String create(Model model) {
		Mascota mascota = new Mascota();
		model.addAttribute("title", "Registro de nueva mascota");
		model.addAttribute("mascota", mascota); 
		return "mascota/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Mascota mascota = srvMascota.findById(id);
		model.addAttribute("mascota", mascota);				
		return "mascota/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Mascota mascota = srvMascota.findById(id);
		model.addAttribute("mascota", mascota);
		model.addAttribute("title", "Actualizando el registro de " + mascota);
		return "mascota/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvMascota.delete(id);
		return "redirect:/mascota/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Mascota> mascotas = srvMascota.findAll();
		model.addAttribute("mascotas", mascotas);
		model.addAttribute("title", "Listado de mascotas");
		return "mascota/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(Mascota mascota, Model model) {
		srvMascota.save(mascota);
		return "redirect:/mascota/list";
	}
}
