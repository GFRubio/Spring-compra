package com.example.data.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.model.Ingrediente;
import com.example.data.model.Menu;
import com.example.data.model.Receta;
import com.example.data.repository.RecetaRepository;

@Service
public class RecetaServiceImpl implements RecetaService{

	private final RecetaRepository recetaRepository;

	@PostConstruct
	public void RecetaServiceImpl() {

	}

	@Autowired
	public RecetaServiceImpl(RecetaRepository recetaRepository) {

		System.out.println("\t Constructor Receta service implements ");
		this.recetaRepository = recetaRepository;

	}

	public RecetaServiceImpl() {
		this.recetaRepository = null;

	}


	@Override
	public Iterable <Receta> crearReceta(Receta receta) {
		recetaRepository.save(receta);
		return findAllRecetas();
	}

	@Override
	public Optional<Receta> findRecetaById(Long receta_id) {
		return recetaRepository.findById(receta_id);
	}

	@Override
	public Iterable<Receta> deleteRecetaById(Long id) {
		recetaRepository.deleteById(id);
		return findAllRecetas();
	}

	@Override
	public Iterable<Receta> updateReceta(Receta receta) {
		// TODO Auto-generated method stub
		recetaRepository.save(receta);
		return findAllRecetas();
	}

	@Override
	public Iterable<Receta> updateIdAndMenuReceta(Long id, Menu menu, List<Ingrediente> ingredientes) {
		// TODO Auto-generated method stub
		Receta r = findRecetaById(id).get();
		r.setMenu(menu);
		r.listIngredientes(ingredientes);;
		recetaRepository.save(r);
		return findAllRecetas();
	}

	@Override
	public Iterable<Receta> findAllRecetas() {
		return recetaRepository.findAll();
	}

	
	
	
}
