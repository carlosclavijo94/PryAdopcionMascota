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
import com.brionesclavijo.mascota.models.entities.Mascota;
import com.brionesclavijo.mascota.models.services.IMascotaService;
import com.brionesclavijo.mascota.models.entities.Vacuna;
import com.brionesclavijo.mascota.models.services.IVacunaService;

@Controller
@RequestMapping(value="/carnet")  
public class CarnetVacunacionController {
	@Autowired 
	private ICarnetVacunacionService srvCarnetVacunacion;
	
	@Autowired 
	private IMascotaService srvMascota;
	
	@Autowired 
	private IVacunaService srvVacuna;
	
	
	
	
	@GetMapping(value="/create") //https://localhost:8084/carnet/create
	public String create(Model model) {
		CarnetVacunacion carnet = new CarnetVacunacion();
		model.addAttribute("title", "Registro de nuevo Carnet de Vacunación");
		model.addAttribute("carnet", carnet);		
		List<Vacuna> vacunas = srvVacuna.findAll();
		model.addAttribute("vacunas", vacunas);
		List<Mascota> mascotas = srvMascota.findAll();
		model.addAttribute("mascotas", mascotas);
		return "carnet/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		CarnetVacunacion carnet = srvCarnetVacunacion.findById(id);
		model.addAttribute("carnet", carnet);				
		return "carnet/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		CarnetVacunacion carnet = srvCarnetVacunacion.findById(id);
		model.addAttribute("carnet", carnet);
		model.addAttribute("title", "Actualizando el registro de " + carnet);
		List<Vacuna> vacunas = srvVacuna.findAll();
		model.addAttribute("vacunas", vacunas);
		List<Mascota> mascotas = srvMascota.findAll();
		model.addAttribute("mascotas", mascotas);
		
		return "carnet/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvCarnetVacunacion.delete(id);
		return "redirect:/carnet/list";		
	}
	
	@GetMapping(value={"","/","/list"})
	public String list(Model model) {
		List<CarnetVacunacion> lstcarnet = srvCarnetVacunacion.findAll();
		model.addAttribute("lstcarnet", lstcarnet);
		model.addAttribute("title", "Listado de carnets");
		return "carnet/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(CarnetVacunacion carnetVacunacion, Model model) {
		srvCarnetVacunacion.save(carnetVacunacion);
		return "redirect:/carnet/list";
	}
}

