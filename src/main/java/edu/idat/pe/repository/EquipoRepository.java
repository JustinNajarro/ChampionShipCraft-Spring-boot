package edu.idat.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.idat.pe.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    @Query("SELECT e FROM Equipo e WHERE e.torneo.idTorneo = :idTorneo")
    List<Equipo> findByTorneoId(@Param("idTorneo") Integer idTorneo);
}



