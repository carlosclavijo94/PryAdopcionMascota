package com.brionesclavijo.mascota.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brionesclavijo.mascota.models.entities.Adopcion;
import com.brionesclavijo.mascota.models.entities.Persona;
import com.brionesclavijo.mascota.models.entities.Mascota;
import com.brionesclavijo.mascota.models.services.IAdopcionService;
import com.brionesclavijo.mascota.models.services.IMascotaService;
import com.brionesclavijo.mascota.models.services.IPersonaService;
import com.brionesclavijo.mascota.models.reporting.CltAdopcionMascotas;

@Controller
@RequestMapping(value="/adopcion")  
public class AdopcionController {
	
	@Autowired 
	private IAdopcionService srvAdopcion;
	
	@Autowired
	private IMascotaService srvMascota;
	
	@GetMapping(value="/create") //https://localhost:8084/adopcion/create
	public String create(Model model) {
		Adopcion adopcion = new Adopcion();	
		model.addAttribute("title", "Registro de nueva adopcion");
		model.addAttribute("adopcion", adopcion); 		
		List<Mascota> mascotas = srvMascota.findAll();
		model.addAttribute("mascotas", mascotas);
		
		return "adopcion/form";
	}
	
	@GetMapping(value="/galeria") //https://localhost:8084/adopcion/create
	public String galeria(Model model) {
		List<Adopcion> adopciones=srvAdopcion.findByEstado("DISPONIBLE");
		model.addAttribute("title", "Registro de nueva adopcion");
		model.addAttribute("adopciones", adopciones); 		
		List<Mascota> mascotas = srvMascota.findAll();
		model.addAttribute("mascotas", mascotas);
		
		return "adopcion/galeria";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Adopcion adopcion = srvAdopcion.findById(id);
		model.addAttribute("adopcion", adopcion);				
		return "adopcion/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Adopcion adopcion = srvAdopcion.findById(id);
		model.addAttribute("adopcion", adopcion);
		model.addAttribute("title", "Actualizando el registro de " + adopcion);
		
		List<Mascota> mascotas = srvMascota.findAll();
		model.addAttribute("mascotas", mascotas);
		
		return "adopcion/form";
	}
	
	@GetMapping(value="/adoptar/{id}")
	public String adoptar(@PathVariable(value="id") Integer id, Model model) {
		Adopcion adopcion = srvAdopcion.findById(id);
		model.addAttribute("adopcion", adopcion);
		model.addAttribute("title", "Realizar Adopción de " + adopcion);
		List<Mascota> mascotas = srvMascota.findAll();
		model.addAttribute("mascotas", mascotas);
		return "adopcion/adoptar";
	}
	@PostMapping(value="/save2") 
	public String save2(Adopcion adopcion, Model model)  {
		adopcion.Actualizar();
		srvAdopcion.save(adopcion);
		return "redirect:/adopcion/list";
	}
	
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvAdopcion.delete(id);
		return "redirect:/adopcion/list";		
	}
	
	@GetMapping(value={"","/","/list"})
	public String list(Model model) {
		List<Adopcion> adopciones = srvAdopcion.findAll();
		model.addAttribute("adopciones", adopciones);
		model.addAttribute("title", "Listado de adopciones");
		return "adopcion/list";
	}
	
	@PostMapping(value="/save") 
	public String save(Adopcion adopcion, Model model)  {
		srvAdopcion.save(adopcion);
		return "redirect:/adopcion/list";
	}
	
	@GetMapping(value = "/cltAdopcionMascotas")
	public String cltAdopcionMascotas(Model model) {
		return "adopcion/galeria";				
	}
	
	@GetMapping(value = "/dataCltAdopcionMascotas", produces="application/json")
	public @ResponseBody List<CltAdopcionMascotas> dataCltAdopcionMascotas(Model model) {				
		try {			
			return this.srvAdopcion._cltAdopcionMascotas();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}		
	}
}



