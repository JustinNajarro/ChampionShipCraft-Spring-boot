package edu.idat.pe.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.idat.pe.model.Usuario;

@SuppressWarnings("serial")
public class UsuarioSecurity implements UserDetails {

	private final Usuario usuario;
	
	public UsuarioSecurity(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String getUsername() {
		return usuario.getUsername();
	}

	@Override
	public String getPassword() {
		return usuario.getContraseña();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}