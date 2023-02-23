package com.example.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.data.model.Ingrediente;
import com.example.data.model.Usuario;



@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
	

}
