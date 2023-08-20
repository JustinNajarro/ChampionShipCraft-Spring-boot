package edu.idat.pe.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import edu.idat.pe.model.Encuentro;
import edu.idat.pe.model.Jornada;
import edu.idat.pe.model.TablaPosiciones;
import edu.idat.pe.model.Torneo;
import edu.idat.pe.service.EncuentroService;
import edu.idat.pe.service.FixtureService;
import edu.idat.pe.service.JornadaService;
import edu.idat.pe.service.TablaPosicionesService;
import edu.idat.pe.service.TorneoService;

@Controller
public class FixtureController {
	private final TorneoService torneoService;
	private final FixtureService fixtureService;
	private final JornadaService jornadaService;
    private final EncuentroService encuentroService;
    private final TablaPosicionesService tablaPosicionesService;
    
	public FixtureController(TorneoService torneoService, FixtureService fixtureService, JornadaService jornadaService,
			EncuentroService encuentroService, TablaPosicionesService tablaPosicionesService) {
		super();
		this.torneoService = torneoService;
		this.fixtureService = fixtureService;
		this.jornadaService = jornadaService;
		this.encuentroService = encuentroService;
		this.tablaPosicionesService = tablaPosicionesService;
	}

	@GetMapping("/fixture")
    public String mostrarPaginaFixture(Model model, @RequestParam("idTorneo") Integer idTorneo) {
        List<Jornada> jornadas = jornadaService.obtenerJornadasPorTorneo(idTorneo);
        model.addAttribute("idTorneo", idTorneo);
        model.addAttribute("jornadas", jornadas);

        /* Obtener la tabla de posiciones usando el servicio TablaPosicionesService
        List<TablaPosiciones> tablaPosiciones = tablaPosicionesService.obtenerTablaPosiciones(idTorneo);
        model.addAttribute("tablaPosiciones", tablaPosiciones);*/

        return "Home/fixture";
    }

    @GetMapping("/tablaPosiciones")
    public String mostrarPaginaTabla(Model model, @RequestParam("idTorneo") Integer idTorneo) {

        List<TablaPosiciones> tablaPosiciones = tablaPosicionesService.obtenerTablaPosiciones(idTorneo);
        model.addAttribute("tablaPosiciones", tablaPosiciones);

        return "Home/tablaPosiciones";
    }

    @GetMapping("/encuentros")
    @ResponseBody
    public List<Encuentro> obtenerEncuentrosPorJornada(@RequestParam("idJornada") Integer idJornada) {
        List<Encuentro> encuentros = encuentroService.obtenerEncuentrosPorJornada(idJornada);
        return encuentros;
    }

    @PostMapping("/generar-fixture")
    public String generarFixturedelTorneo(@RequestParam("idTorneo") Integer idTorneo, Model model) {
        Torneo torneo = torneoService.obtenerTorneoPorId(idTorneo);

        if (torneo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El torneo con ID " + idTorneo + " no existe.");
        }

        List<Integer> equipos = new ArrayList<>();
        fixtureService.recuperarEquipos(idTorneo, equipos);


        fixtureService.generarFixture(equipos, idTorneo);

        return "redirect:/fixture?idTorneo=" + idTorneo;
    }
    
    @PostMapping("/actualizar-goles-y-estado")
    public String actualizarGolesYEstado(@RequestBody Encuentro encuentro) {
        int idEncuentro = encuentro.getIdEncuentro();
        int golesLocal = encuentro.getGolesLocal();
        int golesVisita = encuentro.getGolesVisita();

        encuentroService.actualizarGolesYEstado(idEncuentro, golesLocal, golesVisita);

        return "Home/jugadores";
    }

    @PostMapping("/actualizar-fecha")
    public String actualizarFecha(@RequestBody Encuentro encuentro) {
        int idEncuentro = encuentro.getIdEncuentro();
        LocalDateTime fechaEncuentro = encuentro.getFechaEncuentro();

        encuentroService.actualizarFecha(idEncuentro, fechaEncuentro);

        return "Home/jugadores";
    }
}
