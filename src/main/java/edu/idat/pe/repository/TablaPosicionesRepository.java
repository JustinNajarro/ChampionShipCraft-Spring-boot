package edu.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.idat.pe.model.TablaPosiciones;

@Repository
public interface TablaPosicionesRepository extends JpaRepository<TablaPosiciones, Integer>{
	
	
}
