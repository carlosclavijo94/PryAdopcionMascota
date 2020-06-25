package com.brionesclavijo.mascota.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class MainController {
	
	@GetMapping(value= {"/","/index.html"})
	//los metodos pueden llevar a cabo varias peticiones
	public String index(Model model) {
		//El retorno indica la vista que se va a desplegar
		//se coloca únicamente el nombre sin la extension
		return "index";
	}
	
	@GetMapping(value="/tables.html")
	public String tables(Model model) {						
		return "tables";
	}
	
	@GetMapping(value="/register.html")
	public String register(Model model) {						
		return "register";
	}
	
	@GetMapping(value="/about.html")
	public String about(Model model) {						
		return "about";
	}
	
	@GetMapping(value="/gallery.html")
	public String galeria(Model model) {						
		return "gallery";
	}
	
	@GetMapping(value={"adopcion/contact.html","/contact.html"})
	public String contacto(Model model) {						
		return "contact";
	}
	
	

}
