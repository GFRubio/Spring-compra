package com.example.data.commandLineRunner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.data.model.Menu;
import com.example.data.model.ListaCompra;
import com.example.data.model.Receta;
import com.example.data.model.Ingrediente;
import com.example.data.model.Usuario;
import com.example.data.repository.UsuarioRepository;
import com.example.data.repository.RecetaRepository;


//@Component
//public class startRunner implements CommandLineRunner{
//	
//	@Autowired
//	private UsuarioRepository usuarioRepository;	
//	@Autowired
//	private RecetaRepository recetaRepository;
//		
//	public startRunner(UsuarioRepository usuarioRepository, RecetaRepository recetaRepository) {		
//	this.usuarioRepository = usuarioRepository;	
//	this.recetaRepository = recetaRepository;
//	
//	// TODO Auto-generated constructor stub
//	}
//	
//	public startRunner() {						
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public void run (String... args) throws Exception {
//		System.out.println("\t startRunner execution");
//		iniciarUsuarios();
//		iniciarRecetas();
//		
//	}
//	
//	private void iniciarUsuarios() {
//		System.out.println("\t startRunner: creando usuarios para la BD");
//		//Crear tres de usuarios y le añadimos direcciones. Inicializacion de la BD "poco elegante".
//		Usuario usuario01 = new Usuario("Guille","guille@unex.es", "1234");
//		Usuario usuario02 = new Usuario("Paco","paco@gmail.com", "paco");
//		Usuario usuario03 = new Usuario("Alba","albaricoque@gmail.com", "albita");
//		
//		usuario01.addListaCompra(new ListaCompra(1));
//		usuario01.addMenu(new Menu());
//		
//		usuario02.addListaCompra(new ListaCompra(2));
//		usuario02.addMenu(new Menu());
//		
//		usuario03.addListaCompra(new ListaCompra(3));
//		usuario03.addMenu(new Menu());
//		
//		usuario01 = usuarioRepository.save(usuario01);
//		usuario02 = usuarioRepository.save(usuario02);
//		usuario03 = usuarioRepository.save(usuario03);
//		
//	}
//	
//	
//	private void iniciarRecetas() {
//		System.out.println("\t startRunner: creando recetas para la BD");
//		//Crear dos de recetas y le añadimos direcciones. Inicializacion de la BD "poco elegante".
//		Receta receta01 = new Receta(1);
//		Receta receta02 = new Receta(2);
//		
//		
//		receta01 = recetaRepository.save(receta01);
//		receta02 = recetaRepository.save(receta02);
//		
//	}
//
//}
