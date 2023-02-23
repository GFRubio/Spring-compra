package com.example.data.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.data.model.Ingrediente;
import com.example.data.model.Menu;
import com.example.data.model.Receta;

public interface RecetaService {

public Iterable <Receta> crearReceta(Receta receta);
	
	public Optional<Receta> findRecetaById(Long receta_id);
	
	public Iterable<Receta> deleteRecetaById(Long id);
	
	public Iterable<Receta> updateReceta (Receta receta);
	
	public Iterable<Receta> updateIdAndMenuReceta(Long id, Menu menu, List<Ingrediente> ingredientes);
	
	public Iterable <Receta> findAllRecetas();
	
	
}
