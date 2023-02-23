package com.example.data.service;

import java.util.Optional;

import com.example.data.model.Menu;

public interface MenuService {
	
	
	public Iterable <Menu> crearMenu(Menu menu);
	
	public Optional<Menu> findMenuById(Long MenuID);
	
	public Iterable<Menu> deleteMenuById(Long id);
	
	public Iterable<Menu> updateMenu (Menu menu);
	
	public Iterable <Menu> findAllUser();

}
