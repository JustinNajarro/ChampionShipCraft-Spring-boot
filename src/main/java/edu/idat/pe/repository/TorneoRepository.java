package edu.idat.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.idat.pe.model.*;

@Repository

public interface TorneoRepository extends JpaRepository<Torneo, Integer> {
    @Query("SELECT t FROM Torneo t WHERE t.usuario = ?1")
    List<Torneo> findTournamentsByIdUser(Usuario usuario);

    @Query("SELECT t FROM Torneo t WHERE t.idTorneo IN (SELECT f.torneo.idTorneo FROM Fixture f)")
    List<Torneo> findTorneosConFixture();

}
