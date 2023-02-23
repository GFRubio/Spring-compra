package com.example.data.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.data.model.Ingrediente;
import com.example.data.model.Receta;
import com.example.data.model.Usuario;
import com.example.data.service.IngredienteService;
import com.example.data.service.RecetaService;

@Controller
public class RecetaController {

	
	private final RecetaService recetaService;
	private final IngredienteService ingredienteService;
	

	@Autowired
	  public RecetaController(RecetaService recetaService, IngredienteService ingredienteService) {
			super();
			this.recetaService = recetaService;
			this.ingredienteService = ingredienteService;
			System.out.println("\t Constructor RecetaController");
		}
	
	 /**
	  get Receta
	 */
	  @GetMapping("/addReceta")
		public String showaddRecetaForm(Receta receta) {
		  	System.out.println("\t entrar en ADDRE");
			return "addReceta";

		}
	  
//	  @GetMapping
//	  public String index(@RequestParam(value = "idrec", required = false) Integer idrec, Model model) {
//		  model.addAttribute("idrec", idrec);
//		  return "index";
//	  }
	
		@PostMapping("/addReceta")
			public String obtenerId(@RequestParam Map<String, String> form, Model model){
			
			
			System.out.println(form.toString());
	        System.out.println("valor"+form.get("idrec"));
			Integer uno = Integer.valueOf(form.get("idrec2"));
			Integer dos =  Integer.valueOf(form.get("idrec3"));
			Integer tres =  Integer.valueOf(form.get("idrec4"));
			Integer cuatro =  Integer.valueOf(form.get("idrec5"));
			Integer cinco =  Integer.valueOf(form.get("idrec6"));
			Integer seis =  Integer.valueOf(form.get("idrec7"));
			
			System.out.println(uno);
			
			List<Ingrediente> ingreds= new ArrayList<Ingrediente>();
			ingreds.addAll(new Receta(uno).getIngredientes());
			ingreds.addAll(new Receta(dos).getIngredientes());
			ingreds.addAll(new Receta(tres).getIngredientes());
			ingreds.addAll(new Receta(cuatro).getIngredientes());
			ingreds.addAll(new Receta(cinco).getIngredientes());
			ingreds.addAll(new Receta(seis).getIngredientes());
			
			for (Ingrediente i : ingreds) {
			    
				model.addAttribute("ingredientes", ingredienteService.crearIngrediente(i));
				
				
			}
			System.out.println("Prueba"+ ingreds.toString());
		          
				return "redirect:/compraFinal";
			}
			
		
	  
//			 @PostMapping("/addReceta")    
//		  public String addReceta(Receta receta, Model model){
//		  	System.out.println("\t cambiamos a compraFinal");    	    	
//
//		  	//le pedimos al servicio que nos cree una receta
//		      model.addAttribute("recetas", recetaService.crearReceta(receta));  	
//		      return "redirect:/compraFinal"; //redirigimos la URL 
//		  }  

		 
		 
		 @GetMapping("/compraFinal")
		  public String compraFinal (Model model) {
		  	System.out.println("\t listaCompra");  		 
	         	   
		   List<Ingrediente> ingredienteList = (List<Ingrediente>) ingredienteService.findAllIngredientes();
		   System.out.println(ingredienteList.toString());
		  	model.addAttribute("ingredientes", ingredienteList.isEmpty() ? Collections.EMPTY_LIST : ingredienteList);
		  	
		  	
		      return "compraFinal";
		  }
		 
		 
//			//Procesa la peticion GET a http://localhost:8080/listarUsuarios
//		  @GetMapping("/listarUsuarios")
//		  //muestra una tabla con los usuarios del sistema
//		  public String showUsersTable(Model model) {
//		  	System.out.println("\t UsuarioController::showUsersTable");    	    	    	
//		    List<Usuario> usuarioList = (List<Usuario>) usuarioService.findAllUser(); //descubrir el fallo ** revisar html
//		  	System.out.println(usuarioList.toString());
//		      model.addAttribute("usuarios", usuarioList.isEmpty() ? Collections.EMPTY_LIST : usuarioList);        
//		      return "listarUsuarios"; //devuelve la vista a renderizar
//		  }
//		  
//
////
//		  @PostMapping("/addUsuario")    
//		  public String addUsuario(Usuario usuario, Model model){
//		  	System.out.println("\t UsuarioController::addUsuario");    	    	
//		  	///logica de validacion de usuarios, email correcto, repetido o no?, nombre usuario repetido, formato....
//		  	// 
//		  	//  Esquema común: 
//		  	//		Si hay errores entonces 		
//		  	//			devolver la misma vista;
//		  	//Yo no escribo la logica de control de errores. Sorry :(. 
//		  	//Pista: Spring y Thymeleaf proporcionan formas de validar datos...
//
//		  	//le pedimos al servicio que nos cree un usuario    	
//		      model.addAttribute("usuarios", usuarioService.crearUsuario(usuario)); //no es estrictamente necesario añadir el atributo al model aquí.  	
//
//		      return "redirect:/listarUsuarios"; //redirigimos la URL a la vista listarUsuarios
//		  }
//		 
		 
}
