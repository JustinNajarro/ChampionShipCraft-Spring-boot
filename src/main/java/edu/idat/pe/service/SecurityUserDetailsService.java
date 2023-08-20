package edu.idat.pe.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.idat.pe.repository.UsuarioRepository;
import edu.idat.pe.security.UsuarioSecurity;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	public SecurityUserDetailsService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var optUsuario = this.usuarioRepository.findByUsername(username);
		if (optUsuario.isPresent()) {
			return new UsuarioSecurity(optUsuario.get());
		}
		throw new UsernameNotFoundException("User not found: " + username);
	}

}