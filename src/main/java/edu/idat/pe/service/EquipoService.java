package edu.idat.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import edu.idat.pe.model.Delegado;
import edu.idat.pe.model.Equipo;
import edu.idat.pe.model.Torneo;
import edu.idat.pe.repository.DelegadoRepository;
import edu.idat.pe.repository.EquipoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EquipoService {
	private final EquipoRepository equipoRepository;
	private final DelegadoRepository delegadoRepository;

    private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EquipoService(EquipoRepository equipoRepository, DelegadoRepository delegadoRepository, JdbcTemplate jdbcTemplate) {
        this.equipoRepository = equipoRepository;
        this.delegadoRepository = delegadoRepository;
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }
    
    @Transactional
    public void registrarEquipo(String nombreDelegado, String apellidosDelegado, String tipoDocumento, String numDocumento, String telefono,String nomEquipo, String nomEquipoCorto
    		,String ciudad, Torneo torneo) {
    	Delegado delegado = new Delegado();
    	delegado.setNombreDelegado(nombreDelegado);
    	delegado.setApellidosDelegado(apellidosDelegado);
    	delegado.setTipoDocumento(tipoDocumento);
    	delegado.setNumDocumento(numDocumento);
    	delegado.setTelefono(telefono);
    	delegadoRepository.save(delegado);
    	
    	Equipo equipo = new Equipo();
    	equipo.setDelegado(delegado);
    	equipo.setNomEquipo(nomEquipo);
    	equipo.setNomEquipoCorto(nomEquipoCorto);
    	equipo.setCiudad(ciudad);
    	equipo.setTorneo(torneo);
    	equipoRepository.save(equipo);
    }
    
    @Transactional
    public void eliminarEquipo(Integer idEquipo) {
        String procedureCall = "CALL EliminarEquipo(?)";
        jdbcTemplate.update(procedureCall, idEquipo);
    }
    public List<Equipo> obtenerEquiposPorTorneo(Integer idTorneo) {
        return equipoRepository.findByTorneoId(idTorneo);
    }
    
    public Equipo obtenerEquipoPorId(int idEquipo) {
        Optional<Equipo> optionalEquipo = equipoRepository.findById(idEquipo);
        return optionalEquipo.orElse(null);
    }

}
