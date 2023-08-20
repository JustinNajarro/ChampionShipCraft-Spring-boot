package edu.idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import edu.idat.pe.model.TablaPosiciones; // Asegúrate de importar la clase correcta

import java.util.List;

@Service
public class TablaPosicionesService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TablaPosicionesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TablaPosiciones> obtenerTablaPosiciones(int idTorneo) {
        String sql = "CALL sp_TablaPosiciones(?)"; 

        @SuppressWarnings("deprecation")
		List<TablaPosiciones> tablaPosiciones = jdbcTemplate.query(sql, new Object[]{idTorneo}, new BeanPropertyRowMapper<>(TablaPosiciones.class));

        return tablaPosiciones;
    }
}
