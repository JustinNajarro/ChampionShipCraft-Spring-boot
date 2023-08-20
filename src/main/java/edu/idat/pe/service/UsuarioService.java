package edu.idat.pe.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import edu.idat.pe.model.Usuario;
import edu.idat.pe.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuariorepository;
	
	
	public Usuario crearUsuario(Usuario usuario) {
		var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		Usuario __usuario = new Usuario(usuario.getNombre(),usuario.getApellidos(),usuario.getCorreo(),usuario.getUsername(),encoders.encode(usuario.getContraseña()));
		return usuariorepository.save(__usuario);
		
	}
	public Optional<Usuario> findById(int idUsuario) {
        return usuariorepository.findById(idUsuario);
    }
	public Optional<Usuario> findByUsername(String username){
        return usuariorepository.findByUsername(username);

    }
}