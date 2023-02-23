package com.example.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.data.registroDTO.RegistroUsuarioDTO;
import com.example.data.service.UsuarioService;

@Controller
@RequestMapping("/registrarse")
public class RegistroController {

	

	   private UsuarioService usuarioService;

	   public RegistroController(UsuarioService usuarioService) {
		   super();
	      this.usuarioService = usuarioService;
	   }

	   @ModelAttribute("usuario")
	   public RegistroUsuarioDTO usuarioRegistroDTO() {
	      return new  RegistroUsuarioDTO();
	   }

	   @GetMapping
	   public String showRegistrationForm() {
	      return "registrarse";
	   }

	   @PostMapping
	   public String registerUserAccount(@ModelAttribute("usuario") 
	                  RegistroUsuarioDTO usuarioRegistroDTO) {
	      
	      usuarioService.save(usuarioRegistroDTO);
	      return "redirect:/registrarse?success";
	   }
	
	
	
}
