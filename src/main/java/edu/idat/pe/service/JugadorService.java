package edu.idat.pe.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import edu.idat.pe.model.Equipo;
import edu.idat.pe.model.Jugador;
import edu.idat.pe.repository.JugadorRepository;
import jakarta.transaction.Transactional;

@Service
public class JugadorService {



    @Autowired
    private JugadorRepository jugadorRepository;
    private final JdbcTemplate jdbcTemplate;
    public JugadorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Transactional
    public boolean registrarJugador(String nombre, String apellido, String tipoDocumento, String numDocumento, int numCamiseta, String posicion, Equipo equipo) {

        Jugador nuevoJugador = new Jugador();
        nuevoJugador.setNombre(nombre);
        nuevoJugador.setApellido(apellido);
        nuevoJugador.setTipoDocumento(tipoDocumento);
        nuevoJugador.setNumDocumento(numDocumento);
        nuevoJugador.setNumCamiseta(numCamiseta);
        nuevoJugador.setPosicion(posicion);
        nuevoJugador.setEquipo(equipo);
        jugadorRepository.save(nuevoJugador);
        return true;
    }

    public boolean verificarNombreApellidoDuplicado(String nombre, String apellido, Integer idEquipo) {
        Jugador jugadorDuplicado = jugadorRepository.findByNombreAndApellidoAndEquipoId(nombre, apellido, idEquipo);
        return jugadorDuplicado != null;
    }

    public boolean verificarNumCamisetaDuplicado(int numCamiseta, Integer idEquipo) {
        Jugador jugadorDuplicado = jugadorRepository.findByNumCamisetaAndEquipoId(numCamiseta, idEquipo);
        return jugadorDuplicado != null;
    }

    public List<Jugador> obtenerJugadoresPorEquipo(Integer idEquipo) {
        return jugadorRepository.findByEquipoId(idEquipo);
    }

    @Transactional
    public boolean actualizarJugador(Integer idJugador, String nuevoNombre, String nuevoApellido, int nuevoNumCamiseta, String nuevaPosicion) {
        jugadorRepository.actualizarJugador(idJugador, nuevoNombre, nuevoApellido, nuevoNumCamiseta, nuevaPosicion);
        return true;
    }

    public String verificarJugadorTorneo(Integer idEquipo, String numDocumento) {
        String query = "Call VerificarJugadorTorneo(?, ?)";
        String resultado = "";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, idEquipo, numDocumento);

        for (Map<String, Object> row : rows) {
            resultado = (String) row.get("Resultado");
        }
        return  resultado;
    }

    public void eliminarJugador(Integer idJugador) {
        String procedureCall = "CALL EliminarJugador(?)";
        jdbcTemplate.update(procedureCall, idJugador);
    }

}

