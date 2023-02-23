package com.example.data.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Receta {

	
	@PostConstruct
	public void Receta() {
		
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Integer nrec;

	// vamos a cambiarlo por List)
	@OneToMany(mappedBy = "receta", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	@ManyToOne
	private Menu menu;

	
	
	protected Receta() {
		
		
	}
	
	public Receta(Integer nrec) {
		super();
		this.nrec = nrec;
		if (nrec != null)
		recetaFinal(nrec);
	}

	public long getId_Receta() {
		return id;
	}

	public void setId_Receta(long id) {
		this.id = id;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void listIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getNrec() {
		return nrec;
	}

	public void setN_receta(Integer nrec) {
		this.nrec = nrec;
	}

	public void recetaFinal(Integer n) {
		
		if (n == 1) {
			ingredientes.add(new Ingrediente("Pollo", 1200));
			ingredientes.add(new Ingrediente("Patatas", 400));
			ingredientes.add(new Ingrediente("Cebolla", 200));
		}
		if (n == 2) {
			ingredientes.add(new Ingrediente("Espaguetti", 200));
			ingredientes.add(new Ingrediente("Huevos", 2));
			ingredientes.add(new Ingrediente("Queso Curado", 150));
			ingredientes.add(new Ingrediente("Bacon", 120));			
		}
		if (n == 3) {
			ingredientes.add(new Ingrediente("Lentejas", 400));
			ingredientes.add(new Ingrediente("Cebollas", 40));
			ingredientes.add(new Ingrediente("Zanahoria", 200));
			ingredientes.add(new Ingrediente("Patata", 300));	
			ingredientes.add(new Ingrediente("Ajo", 20));	
		}

		if (n == 4) {
			ingredientes.add(new Ingrediente("Patata", 400));
			ingredientes.add(new Ingrediente("Huevos", 6));
			ingredientes.add(new Ingrediente("Jamon York", 100));
			ingredientes.add(new Ingrediente("Queso", 100));	
			ingredientes.add(new Ingrediente("Cebolla", 50));	
		}
		
		if (n == 5) {
			ingredientes.add(new Ingrediente("Queso de untar", 400));
			ingredientes.add(new Ingrediente("Huevos", 4));
			ingredientes.add(new Ingrediente("Galleta", 200));
			ingredientes.add(new Ingrediente("Mermelada", 100));	
		}
		
		if (n == 6) {
			ingredientes.add(new Ingrediente("Tomate", 800));
			ingredientes.add(new Ingrediente("Pan", 200));
			ingredientes.add(new Ingrediente("Pepino", 200));
			ingredientes.add(new Ingrediente("Pimiento", 200));	
		}
		if (n == 7) {
			ingredientes.add(new Ingrediente("Arroz", 800));
			ingredientes.add(new Ingrediente("Huevos", 4));
			ingredientes.add(new Ingrediente("tomate frito", 200));
		}
		
		
	}
	
      public Ingrediente obtenerLista() {
    	  
    	  Ingrediente ing = new Ingrediente("", 0);

    	  for (Ingrediente ingred : ingredientes) {
  			ing = ingred; 		
  		}
    	  
	   return ing;
   }

}
