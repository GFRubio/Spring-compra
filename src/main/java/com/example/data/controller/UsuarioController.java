package com.example.data.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.context.request.WebRequest;

import com.example.data.model.Receta;
import com.example.data.model.Usuario;
import com.example.data.registroDTO.RegistroUsuarioDTO;
import com.example.data.service.RecetaService;
import com.example.data.service.UsuarioService;

@Controller
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
		System.out.println("\t Constructor UsuarioController");
	}

	//
	// La url comienza http:localhost:8080. hola.html está en resources/templates
	// Procesa la peticion a http://localhost:8080/hola
	@GetMapping("/hola")
	public String holaUsuarioControllerThymeleaf(Model model) {
		String texto = "Hola mundo en Spring MVC y Thymeleaf";
		// model es un Map, clave-valor. Clave es un string y valor un Object de Java,
		// por tanto, puede ser un Objeto, una Coleccion...
		model.addAttribute("Bienvenida", texto);
		return "hola"; // devuelve la vista a renderizar
	}

	/**
	 * LISTAR USUARIOS
	 */
	// Procesa la peticion GET a http://localhost:8080/listarUsuarios
	@GetMapping("/listarUsuarios")
	// muestra una tabla con los usuarios del sistema
	public String showUsersTable(Model model) {
		System.out.println("\t UsuarioController::showUsersTable");
		List<Usuario> usuarioList = (List<Usuario>) usuarioService.findAllUser(); // descubrir el fallo ** revisar html
		System.out.println(usuarioList.toString());
		model.addAttribute("usuarios", usuarioList.isEmpty() ? Collections.EMPTY_LIST : usuarioList);
		return "listarUsuarios"; // devuelve la vista a renderizar
	}

	/**
	 * ADD USUARIO
	 */
	// Invocado desde el boton + de listarUsuarios.html
	// muestra el formulario para añadir un usuario
	// el parametro usuario, es "añadido" al modelo automaticamente por Spring
	// Usa la clase del objeto (Usuario) y lo añadirá como el atributo usuario al
	// Model
	// Sigue la convencion de nombres. Mombre de variable: el de la clase con la
	// primera con minuscula.
	// Salvo que la clase tenga dos mayusculas seguidas al principio que la variable
	// se llamara como la clase

	@GetMapping("/admin/addUsuario")
	public String showAddUsuarioForm(Usuario usuario) {
		System.out.println("\t UsuarioController::showAddUsuarioForm");
		return "addUsuario";
	}

	// Invocado desde el boton del formulario añadir usuario de addUsuario.html
	// La vinculacion entre el formulario y el metodo nos proporciona en usuario los
	// datos introducidos.
	// No añadimos direcciones pq es una vista "admin" y porque es un ejemplo
	// simple...
	@PostMapping("/admin/addUsuario")
	public String addUsuario(Usuario usuario, Model model) {
		System.out.println("\t UsuarioController::addUsuario");
		/// logica de validacion de usuarios, email correcto, repetido o no?, nombre
		/// usuario repetido, formato....
		//
		// Esquema común:
		// Si hay errores entonces
		// devolver la misma vista;
		// Yo no escribo la logica de control de errores. Sorry :(.
		// Pista: Spring y Thymeleaf proporcionan formas de validar datos...

		// le pedimos al servicio que nos cree un usuario
		model.addAttribute("usuarios", usuarioService.crearUsuario(usuario)); // no es estrictamente necesario añadir el
																				// atributo al model aquí.

		return "redirect:/listarUsuarios"; // redirigimos la URL a la vista listarUsuarios
	}

//   PRUEBA
//  @GetMapping("/addReceta")
//		public String showaddRecetaForm(Usuario usuario) {
//		  	System.out.println("\t RecetaController::addReceta");    
//			return "addReceta";
//
//		}
// 
	/**
	 * Update USUARIO
	 */

	// Invocado desde el boton editar de listarUsuarios.html
	// nombre mapeado para spring será: /updateUsuario/id, donde id es el Long del
	// id del usuario
	@GetMapping("/updateUsuario/{id}")
	// @PathVariable: El parámetro forma parte de la URL
	public String showUpdateUsuarioForm(@PathVariable("id") Long usuarioId, Model model) {
		System.out.println("\t UsuarioController::showUpdateUsuarioForm");
		// le pedimos al servicio que nos busque el objeto usuario clickado en el edit.
		// lo añadimos a model, su clave será "usuarioUpdate". Podremos acceder a él
		// desde la vista actualizarUsuario
		// el .get final es por el Optional devuelto.
		model.addAttribute("usuarioUpdate", usuarioService.findUsuarioById(usuarioId).get());
		// nombre de la vista html, diferente escrito en castellano a idea, para que
		// veais que es posible.
		// devolvera el nombre del .html (actualizarUsuario.html), lo mostrará, pero la
		// url en la barra direcciones sera /updateUsuario/id
		return "actualizarUsuario";
	}

	// Invocado desde el boton de actualizarUsuario.html
	@PutMapping("/updateUsuario/{id}")
	public String updateUsuario(@PathVariable("id") Long id, Usuario usuario, Model model) {
		System.out.println("\n\t UsuarioController::updateUsuario");

		// opcion 2 "logica" en services. No es estrictamente necesario incluirlo en
		// model.
		usuarioService.updateNameAndEmailUsuario(id, usuario.getName(), usuario.getEmail());
		model.addAttribute("usuarios",
				usuarioService.updateNameAndEmailUsuario(id, usuario.getName(), usuario.getEmail()));

		// OJO: observar, aunque no necesaria aquí, la copia de direcciones sobre el
		// usuario en el input oculto del html (actualizarUsuario.html)
		return "redirect:/listarUsuarios";
	}

	/**
	 * DELETE USUARIO
	 */
	// Es invocado desde el boton típico de la papelera en listarUsuarios.html
	// se le envía el id del usuario y este se añade url con @PathVariable, aunque
	// no llega a mostrarse la URL por la redireccion
	@DeleteMapping("/deleteUsuario/{id}")
	public String deleteUsuario(@PathVariable("id") Long id, Model model) {
		System.out.println("\t usuarioController::deleteUsuario");
		// no es estrictamente necesario añadir los usuarios al modelo en este caso
		model.addAttribute("usuarios", usuarioService.deleteUsuarioById(id));
		return "redirect:/listarUsuarios";
	}
	
	
	
	
//	// Login form
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
//
	
	
	
	
//	// Login form with error
//	@GetMapping("/login-error")
//	public String loginError(Model model) {
//		model.addAttribute("loginError", true);
//		return "login";
//	}

	// REGISTRARSE
	
	
	 

//	@GetMapping("/registrarse")
//	public String showRegistrationForm(WebRequest request, Model model) {
//		Usuario usuario = new Usuario();
//		model.addAttribute("usuario", usuario);
//		return "registrarse";
//	}
//
//	@PostMapping("/registrarse")
//	public String addRegistro(Usuario usuario, Model model, BindingResult result) {
//		{
//			
//			Usuario existe = usuarioService.findUsuarioByEmail(usuario.getEmail());
//			
//			if (existe != null && existe.getEmail() != null && !existe.getEmail().isEmpty()) {
//				result.rejectValue("email", null, "Ya hay una cuenta registrada con el mismo email");
//				
//			}
//			
//			if (result.hasErrors()) {
//				model.addAttribute("usuario", usuario);
//				return "/registrarse";
//			}
//			
//			model.addAttribute("usuarios", usuarioService.crearUsuario(usuario));
//			return "redirect:/index.html";
//		}
//	}
	
	


}
