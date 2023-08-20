package edu.idat.pe.controller;

import edu.idat.pe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import edu.idat.pe.service.*;

@Controller
public class HomeController {

    private final TorneoService torneoService;
    private final JornadaService jornadaService;
    private final TablaPosicionesService tablaPosicionesService;
    private final EmailSenderService emailSender;

    @Autowired
    public HomeController(TorneoService torneoService, JornadaService jornadaService, TablaPosicionesService tablaPosicionesService, EmailSenderService emailSender) {
        this.torneoService = torneoService;
        this.jornadaService = jornadaService;
        this.tablaPosicionesService = tablaPosicionesService;
        this.emailSender = emailSender;
    }
    
    @GetMapping("/home")
    public String home() {
        return "Home/home";
    }

    @GetMapping("/FAQ")
    public String FAQ() {
        return "Home/FAQ";
    }
    
    @GetMapping("/seguirTorneo")
    public String seguirTorneo(Model model) {
        List<Torneo> torneosConFixture = torneoService.obtenerTorneosConFixture();
        model.addAttribute("torneosConFixture", torneosConFixture);
        return "Home/seguirTorneo";
    }

    @GetMapping("/seguirFixture")
    public String seguirFixture(Model model,
                                @RequestParam("idTorneo") Integer idTorneo) {
        List<Jornada> jornadas = jornadaService.obtenerJornadasPorTorneo(idTorneo);
        model.addAttribute("idTorneo", idTorneo);
        model.addAttribute("jornadas", jornadas);
        List<TablaPosiciones> tablaPosiciones = tablaPosicionesService.obtenerTablaPosiciones(idTorneo);
        model.addAttribute("tablaPosiciones", tablaPosiciones);

        return "Home/seguirFixture";
    }
    
    @GetMapping("/consulta")
    public String consultation(Model model) {
    	return "Home/contact";
    }
    
    @PostMapping("/consulta")
    public String sendEmail(@RequestParam("toEmail") String toEmail,
    						@RequestParam("name") String name,
    						@RequestParam("consultation") String consultation,
    						@RequestParam("subject") String subject,
    						@RequestParam("details") String details
    		) {
    	if(details.isEmpty()) {
    		String detailsNull = "No hubo detalles";
    		emailSender.sendEmail(toEmail, name, consultation, subject, detailsNull);
    	} else {
    		emailSender.sendEmail(toEmail, name, consultation, subject, details);
    	}
    	return "Home/contact-success";
    }
}