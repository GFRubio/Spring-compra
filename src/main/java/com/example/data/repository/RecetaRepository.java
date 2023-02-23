package com.example.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.data.model.Receta;
import com.example.data.model.Usuario;

@Repository
public interface RecetaRepository extends CrudRepository<Receta, Long> {
	

}
