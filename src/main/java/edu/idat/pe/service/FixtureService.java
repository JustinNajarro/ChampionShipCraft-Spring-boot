package edu.idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class FixtureService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FixtureService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void recuperarEquipos(Integer torneoId, List<Integer> equipos) {
        String query = "CALL RecuperarEquipos(?)";
        
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, torneoId);
        
        for (Map<String, Object> row : rows) {
            Integer equipo = (Integer) row.get("ID_Equipo");
            
            equipos.add(equipo);
        }
        
        
    }
    
    public String recuperarNombreCortoEquipo(Integer equipoId) {
        String query = "CALL RecuperarNomCortoEquipo(?)";
        String equipo = "";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, equipoId);
        
        for (Map<String, Object> row : rows) {
            equipo = (String) row.get("Nombre_corto");

        }
        
        return equipo;
    }

    @Transactional
	public void generarFixture(List<Integer> equipos, int torneoId) {

		String nom_cortoLocal = "";
		String nom_cortoVisita = "";

		if (equipos.size() % 2 != 0) {
			equipos.add(0);
		}

		int cantEquipos = equipos.size();
		int cantEncuentros = cantEquipos / 2;
		int cantJornadas = cantEquipos - 1;


		String fixtureQuery = "INSERT INTO Fixture (ID_Torneo, Cant_Jornadas) VALUES (?, ?)";
		jdbcTemplate.update(fixtureQuery, torneoId, cantJornadas);

		int fixtureId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

		for (int ronda = 0; ronda < cantJornadas; ronda++) {
			String jornadaQuery = "INSERT INTO Jornada (ID_Fixture, Num_Fecha, Cant_Encuentros) VALUES (?, ?, ?)";
			jdbcTemplate.update(jornadaQuery, fixtureId, ronda + 1, cantEncuentros);

			int jornadaId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

			for (int i = 0; i < cantEncuentros; i++) {
				int localIndex = i;
				int visitanteIndex = cantEquipos - 1 - i;
				Integer local = equipos.get(localIndex);
				Integer visitante = equipos.get(visitanteIndex);
				nom_cortoLocal = recuperarNombreCortoEquipo(local);
				nom_cortoVisita = recuperarNombreCortoEquipo(visitante);


				String encuentroQuery = "INSERT INTO Encuentro (ID_Equipo_Local, ID_Equipo_Visita , Equipo_Local, Equipo_Visita, Goles_Local, Goles_Visita, Estado, ID_Jornada, Fecha_Encuentro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				jdbcTemplate.update(encuentroQuery, local, visitante, nom_cortoLocal, nom_cortoVisita, null, null, "Por Jugar", jornadaId, null);
			}
			Collections.rotate(equipos.subList(1, cantEquipos), 1);
		}
	}

}

