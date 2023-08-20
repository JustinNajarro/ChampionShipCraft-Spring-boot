package edu.idat.pe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.idat.pe.model.Equipo;
import edu.idat.pe.model.Jugador;
import edu.idat.pe.service.EquipoService;
import edu.idat.pe.service.JugadorService;

@Controller
public class JugadorController {
	private final JugadorService jugadorService;
	private final EquipoService equipoService;
	
	public JugadorController(JugadorService jugadorService, EquipoService equipoService) {
		super();
		this.jugadorService = jugadorService;
		this.equipoService = equipoService;
	}

	@GetMapping("/jugadores")
    public String listarJugadoresPorEquipo(Model model, @RequestParam("idEquipo") Integer idEquipo) {
        model.addAttribute("idEquipo", idEquipo);
        List<Jugador> jugadores = jugadorService.obtenerJugadoresPorEquipo(idEquipo);
        model.addAttribute("jugadores", jugadores);

        return "Home/jugadores";
    }

    @PostMapping("/registrar-jugador")
    public String registrarJugador(
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("tipoDocumento") String tipoDocumento,
            @RequestParam("numDocumento") String numDocumento,
            @RequestParam("numCamiseta") int numCamiseta,
            @RequestParam("posicion") String posicion,
            @RequestParam("idEquipo") Integer idEquipo,
            Model model) {

        Equipo equipo = equipoService.obtenerEquipoPorId(idEquipo);
       

        String resultado = jugadorService.verificarJugadorTorneo(idEquipo, numDocumento);
        
        if (jugadorService.verificarNumCamisetaDuplicado(numCamiseta, idEquipo)) {
            model.addAttribute("error", "El número de camiseta ya está en uso para este equipo");
            return "redirect:/jugadores?idEquipo=" + idEquipo;
        }

       if (jugadorService.verificarNombreApellidoDuplicado(nombre, apellido, idEquipo)) {
            model.addAttribute("error", "El nombre y apellido ya están en uso para este equipo");
            return "redirect:/jugadores?idEquipo=" + idEquipo;
       }

        if (resultado.equals("OK")) {
            System.out.println("entroo");
            jugadorService.registrarJugador(nombre, apellido, tipoDocumento, numDocumento, numCamiseta, posicion, equipo);
            return "redirect:/jugadores?idEquipo=" + idEquipo;
        } 
        
        
        else {
            System.out.println(resultado);
            return "redirect:/jugadores?idEquipo=" + idEquipo;
        }

    }
    
    @GetMapping("/jugadores/{idEquipo}") 
    public String mostrarJugadoresRegistrados(@PathVariable("idEquipo") Integer idEquipo, Model model) {
        List<Jugador> jugadores = jugadorService.obtenerJugadoresPorEquipo(idEquipo);
        model.addAttribute("jugadores", jugadores);
        model.addAttribute("idEquipo", idEquipo); // Añadir el idEquipo nuevamente al modelo

        return "Home/jugadores";
    }

    @PostMapping("/jugadores/eliminar")
    public String eliminarJugador(@RequestParam("idJugador") Integer idJugador,@RequestParam("idEquipo") Integer idEquipo,Model model) {
        jugadorService.eliminarJugador(idJugador);

        return "redirect:/jugadores?idEquipo=" + idEquipo;
    }

    @PostMapping("/actualizar-jugador")
    public String actualizarJugador(
            @RequestParam("idJugador") Integer idJugador,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("numCamiseta") int nuevoNumCamiseta,
            @RequestParam("posicion") String nuevaPosicion,
            @RequestParam("idEquipo") Integer idEquipo,
            Model model) {

        if (jugadorService.verificarNumCamisetaDuplicado(nuevoNumCamiseta, idEquipo)) {
            model.addAttribute("error", "El número de camiseta ya está en uso para este equipo");
            return "redirect:/jugadores?idEquipo=" + idEquipo;
        }

//        if (jugadorService.verificarNombreApellidoDuplicado(nuevoNombre, nuevoApellido, idEquipo)) {
//            model.addAttribute("error", "El nombre y apellido ya están en uso para este equipo");
//            return "redirect:/jugadores?idEquipo=" + idEquipo;
//        }

        boolean actualizacionExitosa = jugadorService.actualizarJugador(idJugador, nuevoNombre, nuevoApellido, nuevoNumCamiseta, nuevaPosicion);

        if (actualizacionExitosa) {
            return "redirect:/jugadores?idEquipo=" + idEquipo;
        } else {
            model.addAttribute("error", "Hubo un error al actualizar el jugador.");
            return "error";
        }
    }
}
