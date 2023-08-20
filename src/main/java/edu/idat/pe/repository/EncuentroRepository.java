package edu.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import edu.idat.pe.model.Encuentro;
import java.util.List;

public interface EncuentroRepository extends JpaRepository<Encuentro, Integer> {
    @Query("SELECT e FROM Encuentro e WHERE e.idJornada.idJornada = :idJornada")
    List<Encuentro> findByJornadaId(Integer idJornada);
    
    //@Modifying
    //@Query(value = "UPDATE Encuentro SET Goles_Local = :golesLocal, Goles_Visita = :golesVisita WHERE ID_Encuentro = :idEncuentro", nativeQuery = true)
    //void actualizarResultado(@Param("idEncuentro") Integer idEncuentro, @Param("golesLocal") Integer golesLocal, @Param("golesVisita") Integer golesVisita);
}
