package com.example.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.data.model.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long>{
	
	

}
