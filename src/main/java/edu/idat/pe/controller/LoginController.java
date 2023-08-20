package edu.idat.pe.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.idat.pe.model.Usuario;
import edu.idat.pe.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario()); 
        return "Home/login";
    }


    @GetMapping("/password")
    public String password(Model model) {
        return "Home/password";
    }


    @PostMapping("/usuario/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model, HttpSession session) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        session.setAttribute("userId", nuevoUsuario.getIdUsuario());
        model.addAttribute("usuario", nuevoUsuario);
        return "Home/register-success";
    }

    @GetMapping("/logout")
    public String logout() {
    	return "redirect:/login?logout";
    }
    
    @PostMapping("/process_login")
    public String processLogin(HttpSession session, Principal principal) {
    	String username = principal.getName();
    	Optional<Usuario> optionalUsuario = usuarioService.findByUsername(username);
    	if(optionalUsuario.isPresent()) {
    		return "redirect:/home";
    	} else {
    		return "redirect:/login?error";
    	}
    }
}