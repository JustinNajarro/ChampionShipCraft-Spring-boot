package edu.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.idat.pe.model.Organizador;

@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, Integer> {
    
}
