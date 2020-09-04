package com.brionesclavijo.mascota.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brionesclavijo.mascota.models.entities.CarnetVacunacion;
import com.brionesclavijo.mascota.models.entities.Mascota;
import com.brionesclavijo.mascota.models.services.IMascotaService;
import com.brionesclavijo.mascota.models.services.ICarnetVacunacionService;

@Controller
@RequestMapping(value="/mascota")  
public class MascotaController {
	@Autowired 
	private IMascotaService srvMascota;
	
	@Autowired 
	private ICarnetVacunacionService srvCarnets;
	

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
		
		List<CarnetVacunacion> carnets= this.srvCarnets.findByMascota(mascota);
		model.addAttribute("carnets", carnets);
		     
		
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
	
	@GetMapping(value={"","/","/list"})
	public String list(Model model) {
		List<Mascota> mascotas = srvMascota.findAll();
		model.addAttribute("mascotas", mascotas);
		model.addAttribute("title", "Listado de mascotas");
		return "mascota/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(@Validated Mascota mascota, BindingResult result, Model model,
			@RequestParam("photo") MultipartFile image,
			SessionStatus status, RedirectAttributes flash) {
		try {
			
			String message = "Mascota agregado correctamente";
			String titulo = "Nuevo registro de mascota";
			
			if(mascota.getIdmascota() != null) {
				message = "Mascota actualizado correctamente";
				titulo = "Actualizando el registro de " + mascota;
			}
						
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);							
				return "mascota/form";				
			}
			
			if (!image.isEmpty()) {				
				Path dir = Paths.get("src//main//resources//static//photos");
				String rootPath = dir.toFile().getAbsolutePath();
				try {
					byte[] bytes = image.getBytes();
					Path rutaCompleta = Paths.get(rootPath + "//" + image.getOriginalFilename());
					Files.write(rutaCompleta, bytes);
					mascota.setImagen(image.getOriginalFilename());

				} catch (IOException e) {
					e.printStackTrace();
				}
			}													
			srvMascota.save(mascota);	
			status.setComplete();
			flash.addFlashAttribute("success", message);
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
			return "mascota/form";
		}				
		return "redirect:/mascota/list";
	}
}
