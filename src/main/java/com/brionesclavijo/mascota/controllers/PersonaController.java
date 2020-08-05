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
	public String save(@Validated Persona persona, BindingResult result, Model model,
			@RequestParam("photo") MultipartFile image,
			SessionStatus status, RedirectAttributes flash) {
		try {
			
			String message = "Persona agregado correctamente";
			String titulo = "Nuevo registro de cliente";
			
			if(persona.getIdpersona() != null) {
				message = "Persona actualizado correctamente";
				titulo = "Actualizando el registro de " + persona;
			}
						
			if(result.hasErrors()) {
				model.addAttribute("title", titulo);							
				return "persona/form";				
			}
			
			if (!image.isEmpty()) {				
				Path dir = Paths.get("src//main//resources//static//photos");
				String rootPath = dir.toFile().getAbsolutePath();
				try {
					byte[] bytes = image.getBytes();
					Path rutaCompleta = Paths.get(rootPath + "//" + image.getOriginalFilename());
					Files.write(rutaCompleta, bytes);
					persona.setImagen(image.getOriginalFilename());

				} catch (IOException e) {
					e.printStackTrace();
				}
			}													
			srvPersona.save(persona);	
			status.setComplete();
			flash.addFlashAttribute("success", message);
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", ex.getMessage());
			return "cliente/form";
		}				
		return "redirect:/persona/list";
	}
}
