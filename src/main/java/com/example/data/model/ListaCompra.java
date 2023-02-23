package com.example.data.model;


import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class ListaCompra {


	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private long id_ListaCompra;
	

	
	
	public ListaCompra(Usuario usuario, Set<Ingrediente> ingredientes, Menu menu) {
		super();
		this.usuario = usuario;
		this.ingredientes = ingredientes;
		this.menu = menu;
	}

	@ManyToOne  
	private Usuario usuario;
	@OneToMany(mappedBy ="listaCompra", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	private Set<Ingrediente> ingredientes = new HashSet<>();
    @OneToOne
    private Menu menu;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public ListaCompra(long id_ListaCompra) {
		
		this.id_ListaCompra = id_ListaCompra;
		
	}
	
	public long getId_ListaCompra() {
		return id_ListaCompra;
	}
	public void setId_ListaCompra(long id_ListaCompra) {
		this.id_ListaCompra = id_ListaCompra;
	}
	
	
	public Set<Ingrediente> getIngredientes() {
		
		return ingredientes;
		
	}
	
	public void setIngredientes(Set<Ingrediente> ingredientes) {
		
		this.ingredientes = ingredientes;
	}
	
	public void addIngredientes (Ingrediente i) {
		
		this.getIngredientes().add(i);

	}
	
	public void removerIngredientes (Ingrediente i) {
		
		this.getIngredientes().remove(i);
		i.setListaCompra(null);
		
	}
	
	public void mostrarListaCompra() {
		
		Iterator<Ingrediente> i = ingredientes.iterator();
		System.out.println(i.next().toString());
		while (i.hasNext()) {
			System.out.println(i.next().toString());
		}
	}
	
}
