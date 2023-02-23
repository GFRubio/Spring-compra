package com.example.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.model.Ingrediente;
import com.example.data.repository.IngredienteRepository;

@Service
public class IngredienteServiceImpl implements IngredienteService{

	private final IngredienteRepository ingredienteRepository;
	
	@PostConstruct
	public void IngredienteServiceImpl() {
		
		
	}
	
	@Autowired
	public IngredienteServiceImpl(IngredienteRepository ingredienteRepository) {
		
		System.out.println(" Constructor Ingrediente service implements");
		this.ingredienteRepository = ingredienteRepository;
		
	}
	
	public IngredienteServiceImpl() {
		
		this.ingredienteRepository = null;
		
	}
	
	@Override
	public Iterable<Ingrediente> crearIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
		return findAllIngredientes();
	}

	@Override
	public Optional<Ingrediente> findIngredienteById(Long IngredienteID) {
		return ingredienteRepository.findById(IngredienteID);
	}

	@Override
	public Iterable<Ingrediente> updateIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
		return findAllIngredientes();
	}

	@Override
	public Iterable<Ingrediente> findAllIngredientes() {
		
		return ingredienteRepository.findAll();
	}


	
}
