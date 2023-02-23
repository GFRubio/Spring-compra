package com.example.data.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.data.model.Ingrediente;
import com.example.data.model.Receta;

@Controller
public class ListaCompraController {
	
	  @GetMapping("/miListaCompra")
	   private  String inicio() {
	  
			  	
			  	
				return "miListaCompra";

			}

	
	


}
