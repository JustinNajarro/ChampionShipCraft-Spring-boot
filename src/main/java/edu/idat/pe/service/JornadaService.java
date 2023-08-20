package edu.idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import edu.idat.pe.model.Jornada;
import edu.idat.pe.repository.JornadaRepository;

@Service
public class JornadaService {

    private final JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }
    public List<Jornada> obtenerJornadasPorTorneo(Integer torneoId) {
        return jornadaRepository.findByFixtureTorneoId(torneoId);
    }
}
