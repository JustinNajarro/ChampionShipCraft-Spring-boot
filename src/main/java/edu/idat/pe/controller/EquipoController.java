package edu.idat.pe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.idat.pe.model.Equipo;
import edu.idat.pe.model.Torneo;
import edu.idat.pe.service.EquipoService;
import edu.idat.pe.service.TorneoService;

@Controller
public class EquipoController {
	private final TorneoService torneoService;
    private final EquipoService equipoService;
	
	public EquipoController(TorneoService torneoService, EquipoService equipoService) {
		super();
		this.torneoService = torneoService;
		this.equipoService = equipoService;
	}

	@GetMapping("/registrar-equipo")
    public String crearEquipo(Model model, @RequestParam("idTorneo") Integer idTorneo) {
        model.addAttribute("idTorneo", idTorneo);
        List<Equipo> equipos = equipoService.obtenerEquiposPorTorneo(idTorneo);
        model.addAttribute("equipos", equipos);

        return "Home/registrarEquipo";
    }

    @PostMapping("/registrar-equipo")
    public String registrarEquipo(
            @RequestParam("nombreDelegado") String nombreDelegado,
            @RequestParam("apellidosDelegado") String apellidosDelegado,
            @RequestParam("tipoDocumentoDelegado") String tipoDocumentoDelegado,
            @RequestParam("numDocumentoDelegado") String numDocumentoDelegado,
            @RequestParam("telefonoDelegado") String telefonoDelegado,
            @RequestParam("nombreEquipo") String nombreEquipo,
            @RequestParam("nombreCortoEquipo") String nombreCortoEquipo,
            @RequestParam("ciudadEquipo") String ciudadEquipo,
            @RequestParam("idTorneo") Integer idTorneo,
            Model model) {

        Torneo torneo = torneoService.obtenerTorneoPorId(idTorneo);
        if (torneo != null) {
            equipoService.registrarEquipo(nombreDelegado, apellidosDelegado, tipoDocumentoDelegado, numDocumentoDelegado,
                    telefonoDelegado, nombreEquipo, nombreCortoEquipo, ciudadEquipo, torneo);

            return "redirect:/equipos/" + idTorneo;
        } else {
            throw new RuntimeException("Torneo no encontrado con ID: " + idTorneo);
        }
    }

    @GetMapping("/equipos/{idTorneo}")
    public String mostrarEquiposRegistrados(@PathVariable("idTorneo") Integer idTorneo, Model model) {
        List<Equipo> equipos = equipoService.obtenerEquiposPorTorneo(idTorneo);
        model.addAttribute("equipos", equipos);
        model.addAttribute("idTorneo", idTorneo); 

        return "Home/registrarEquipo";
    }
    
    @PostMapping("/equipos/eliminar")
    public String eliminarEquipo(@RequestParam("idEquipo") Integer idEquipo, @RequestParam("idTorneo") Integer idTorneo ,Model model) {
        equipoService.eliminarEquipo(idEquipo);

        return "redirect:/equipos/" + idTorneo;
    }
}
