package com.example.data.service;


import java.util.Optional;

import com.example.data.model.Ingrediente;


public interface IngredienteService {

	public Iterable<Ingrediente> crearIngrediente(Ingrediente ingrediente);

	public Optional<Ingrediente> findIngredienteById(Long IngredienteID);
	

	public Iterable<Ingrediente> updateIngrediente(Ingrediente ingrediente);

	public Iterable<Ingrediente> findAllIngredientes();

}
