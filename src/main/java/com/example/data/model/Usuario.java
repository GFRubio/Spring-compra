package com.example.data.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "usuario", uniqueConstraints = 
@UniqueConstraint(columnNames = "email"))
public class Usuario {
	
	@PostConstruct
	public void Usuario() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	protected String email;
	private String contra;

	
	@OneToMany (mappedBy ="usuario", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	private Set <ListaCompra> listasCompras = new HashSet<ListaCompra>();
	@OneToMany (mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	private Set <Menu> menus = new HashSet<Menu>();

	  @ManyToMany(fetch = FetchType.EAGER, 
              cascade = CascadeType.ALL)
@JoinTable(name = "users_rol", 
  joinColumns = @JoinColumn(name = "user_id", 
    referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn
         (name = "rol_id", 
            referencedColumnName = "id"))
private Collection<Rol> rol;
    
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String name, String email, String contra) {
		super();
		this.name = name;
		this.email = email;
		this.contra = contra;
	}
	
	public Usuario(String name, String email, String contra, Collection<Rol> rol) {
		super();
		this.name = name;
		this.email = email;
		this.contra = contra;
		this.rol = rol;
	}
	
	public void addMenu(Menu men) {
		menus.add(men);
        men.setUsuario(null);
		
	}
	
	public void borrarMenu (Menu men) {
		menus.remove(men);
	    men.setUsuario(null);
		
	}
	
	public void addListaCompra (ListaCompra lc) {
		listasCompras.add(lc);
		lc.setUsuario(null);
		
	}
	
	public void borrarListaCompra (ListaCompra lc) {
	  listasCompras.remove(lc);
	  lc.setUsuario(null);
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	

	public Set<ListaCompra> getListaCompra() {
		return listasCompras;
	}

	public void setListaCompra(Set<ListaCompra> listaCompra) {
		this.listasCompras = listaCompra;
	}
	


	public Set<Menu> getMenu() {
		return menus;
	}

	public void setMenu(Set<Menu> menu) {
		this.menus = menu;
	}
	
	

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	@Override
	public String toString() {
				
		return "Usuario [id=" + id + ", name=" + name + ", email=" + email + ", listaCompra=" + listasCompras.toString() + 
				",Menu =" + menus.toString()+ "]";
	}

	public Collection<Rol> getRole() {
		return rol;
	}
	
	public void setRole(Collection<Rol> rol) {
		this.rol = rol;
	}
	
}