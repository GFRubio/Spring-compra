package com.example.data.service;

import java.util.Optional;

import com.example.data.model.ListaCompra;

public interface ListaCompraService {
	
	
public Iterable <ListaCompra> crearListaCompra(ListaCompra lc);
	
	public Optional<ListaCompra> findMenuById(Long lcID);
	
	public Iterable<ListaCompra> deleteMenuById(Long id);
	
	public Iterable<ListaCompra> updateMenu (ListaCompra lc);
	
	public Iterable <ListaCompra> findAllUser();

}
