package com.example.data.model;






import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Menu {


	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	
	
	private long id_Menu;
	private ArrayList<String> dia; // lunes martes miercols jueves viernes sabado domingo
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany
	private Set<Receta> recetas = new HashSet<Receta>();
	
	@OneToOne
	private ListaCompra listaCompra;

	
	
	public Menu () {
		
	
		
	}
	

	public Set<Receta> getRecetas() {
		return recetas;
	}


	public void setRecetas(Set<Receta> recetas) {
		this.recetas = recetas;
	}


	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public long getId_Menu() {
		return id_Menu;
	}
	public void setId_Menu(long id_Menu) {
		this.id_Menu = id_Menu;
	}


	public ArrayList<String> getDia() {
		return dia;
	}


	public void setDia(ArrayList<String> dia) {
		this.dia = dia;
	}


	public ListaCompra getListaCompra() {
		return listaCompra;
	}


	public void setListaCompra(ListaCompra listaCompra) {
		this.listaCompra = listaCompra;
	}
	
	
	
}
