package edu.idat.pe.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import edu.idat.pe.model.Torneo;
import edu.idat.pe.model.Usuario;
import edu.idat.pe.service.TorneoService;
import edu.idat.pe.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

 

@Controller
@RequestMapping(path = "/torneo")
public class TorneoController {
    private TorneoService torneoService;
    private UsuarioService usuarioService;


    @Autowired
    public TorneoController(TorneoService torneoService, UsuarioService usuarioService) {
        super();
        this.torneoService = torneoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String torneo(HttpSession session, Principal principal) {
    String username = principal.getName();

            Optional<Usuario> optionalUsuario = usuarioService.findByUsername(username);
            if (optionalUsuario.isPresent()) {
                Usuario usuario = optionalUsuario.get();
                int idUsuario = usuario.getIdUsuario();
                return "redirect:/torneo/"+idUsuario;
            } else {
                throw new RuntimeException("Usuario no encontrado: " + username);
            }
    }

    @GetMapping(path = "{idUsuario}")
    public String torneoById(@PathVariable("idUsuario")int idUsuario, Model model) {
        Optional<Usuario> optionalUsuario = usuarioService.findById(idUsuario);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            List<Torneo> torneos = torneoService.getTorneosByIdUser(usuario);
            model.addAttribute("torneos", torneos);
            return "Home/torneo";
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + idUsuario);
        }
    }
    @PostMapping(path = "{idUsuario}")
      public String eliminarTorneo(@RequestParam Integer id) {
          torneoService.eliminarTorneo(id);
          return "redirect:/torneo";
      }
    
    @GetMapping("/registrar")
    public String crearTorneo(Model model) {
        return "Home/registrarTorneo";
    }

    @PostMapping("/registrar")
    public String registrarTorneo(@RequestParam("nombreOrg") String nombreOrg,
                                  @RequestParam("tipoDocumento") String tipoDocumento,
                                  @RequestParam("numDocumento") String numDocumento,
                                  @RequestParam("telefono") String telefono,
                                  @RequestParam("nombreTorneo") String nombreTorneo,
                                  @RequestParam("direccion") String direccion,
                                  @RequestParam("tipoTorneo") String tipoTorneo,
                                  @RequestParam("cantidadEquipos") int cantidadEquipos,
                                  @RequestParam("montoPremio") String montoPremio,
                                  HttpSession session, Principal principal) {
        String estado = "Activo";
        String username = principal.getName();
        Optional<Usuario> optionalUsuario = usuarioService.findByUsername(username);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            torneoService.registrarTorneo(nombreOrg, tipoDocumento, numDocumento, telefono, nombreTorneo,
                    direccion, tipoTorneo, cantidadEquipos, montoPremio, usuario, estado);
            return "redirect:/torneo";
        } else {
            throw new RuntimeException("Usuario no encontrado: " + username);
        }
    }
}
