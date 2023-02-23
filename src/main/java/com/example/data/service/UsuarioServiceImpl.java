package com.example.data.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.data.model.Rol;
import com.example.data.model.Usuario;
import com.example.data.registroDTO.RegistroUsuarioDTO;
import com.example.data.repository.UsuarioRepository;

@Service("userDetailService")
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;


	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void UsuarioServiceImpl() {

	}

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {

		System.out.println("\t Constructor UsuarioServiceImpl ");
		this.usuarioRepository = usuarioRepository;

	}

	public UsuarioServiceImpl() {
		this.usuarioRepository = null;

	}

	@Override
	public Usuario save(RegistroUsuarioDTO registroUsuarioDTO) {
		
		Usuario usuario = new Usuario(registroUsuarioDTO.getName(), registroUsuarioDTO.getEmail(), 
				passwordEncoder.encode(registroUsuarioDTO.getContra()),
				Arrays.asList(new Rol("ROL_USUARIO")));
		
		return usuarioRepository.save(usuario);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Nombre o contraseña invalido");
		}
		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getContra(),
				mapRolesToAuthorities(usuario.getRole()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> rol) {

		return rol.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	

	
	@Override
	public Iterable<Usuario> crearUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return findAllUser();
	}

	@Override
	public Optional<Usuario> findUsuarioById(Long usuarioId) {
		return usuarioRepository.findById(usuarioId);
	}
	
	@Override
	public Usuario findUsuarioByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Iterable<Usuario> deleteUsuarioById(Long id) {
		usuarioRepository.deleteById(id);
		return findAllUser();
	}

	@Override
	public Iterable<Usuario> updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
		return findAllUser();
	}

	@Override
	public Iterable<Usuario> updateNameAndEmailUsuario(Long id, String name, String email) {
		// TODO Auto-generated method stub
		Usuario u = findUsuarioById(id).get();
		u.setName(name);
		u.setEmail(email);
		usuarioRepository.save(u);
		return findAllUser();
	}

	@Override
	public Iterable<Usuario> findAllUser() {
		return usuarioRepository.findAll();
	}
	



}
