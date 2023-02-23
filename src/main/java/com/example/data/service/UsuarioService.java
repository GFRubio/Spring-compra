package com.example.data.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.data.model.Usuario;
import com.example.data.registroDTO.RegistroUsuarioDTO;

public interface UsuarioService extends UserDetailsService{

	public Iterable <Usuario> crearUsuario(Usuario usuario);
	
	public Usuario findUsuarioByEmail (String email);
	
	public Usuario save(RegistroUsuarioDTO registroUsuarioDTO);
	
	
	public Optional<Usuario> findUsuarioById(Long usuarioID);
	
	public Iterable<Usuario> deleteUsuarioById(Long id);
	
	public Iterable<Usuario> updateUsuario (Usuario usuario);
	
	public Iterable<Usuario> updateNameAndEmailUsuario(Long id, String name, String email);
	
	public Iterable <Usuario> findAllUser();
}
