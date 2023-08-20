package edu.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.idat.pe.model.Delegado;
import edu.idat.pe.repository.*;

@Service
public class DelegadoService {
	private final DelegadoRepository delegadoRepository;

    @Autowired 
    public DelegadoService(DelegadoRepository delegadoRepository) {
        this.delegadoRepository = delegadoRepository;
    }
    
    public List<Delegado> obtenerTodosLosDelegados() {
        return delegadoRepository.findAll();
    }

    public Delegado obtenerDelegadoPorId(Integer id) {
        return delegadoRepository.findById(id).orElse(null);
    }

    public Delegado registrarDelegado(Delegado delegado) {
        return delegadoRepository.save(delegado);
    }

    public void eliminarDelegado(Integer id) {
    	delegadoRepository.deleteById(id);
    }
}
