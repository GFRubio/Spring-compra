package com.example.data.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Ingrediente {


	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private long id_ingrediente;
	private String nombre_ingrediente;
	private int gramos;
	
	@ManyToOne
	private ListaCompra listaCompra;
	@ManyToOne
	private Receta receta;
	
	public Ingrediente() {
		
		
	}
	
	public Ingrediente (String nombre_ing, int gramos) {
		
		nombre_ingrediente = nombre_ing;
		this.gramos = gramos;
	
		
	}

	public long getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(long id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public String getNombre_ingrediente() {
		return nombre_ingrediente;
	}

	public void setNombre_ingrediente(String nombre_ingrediente) {
		this.nombre_ingrediente = nombre_ingrediente;
	}


	public int getGramos() {
		return gramos;
	}

	public void setGramos(int gramos) {
		this.gramos = gramos;
	}

	public ListaCompra getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ListaCompra listaCompra) {
		this.listaCompra = listaCompra;
	}
	

}
