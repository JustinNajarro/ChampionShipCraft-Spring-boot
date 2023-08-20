package edu.idat.pe.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.idat.pe.model.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    @Query("SELECT j FROM Jugador j WHERE j.equipo.idEquipo = :idEquipo")
    List<Jugador> findByEquipoId(@Param("idEquipo") Integer idEquipo);

    @Query("SELECT j FROM Jugador j WHERE j.equipo.idEquipo = :idEquipo AND j.nombre = :nombre AND j.apellido = :apellido")
    Jugador findByNombreAndApellidoAndEquipoId(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("idEquipo") Integer idEquipo);

    @Query("SELECT j FROM Jugador j WHERE j.equipo.idEquipo = :idEquipo AND j.numCamiseta = :numCamiseta")
    Jugador findByNumCamisetaAndEquipoId(@Param("numCamiseta") int numCamiseta, @Param("idEquipo") Integer idEquipo);

    @Modifying
    @Query("UPDATE Jugador j SET j.nombre = :nuevoNombre, j.apellido = :nuevoApellido, j.numCamiseta = :nuevoNumCamiseta, j.posicion = :nuevaPosicion WHERE j.idJugador = :idJugador")
    void actualizarJugador(@Param("idJugador") Integer idJugador, @Param("nuevoNombre") String nuevoNombre, @Param("nuevoApellido") String nuevoApellido, @Param("nuevoNumCamiseta") int nuevoNumCamiseta, @Param("nuevaPosicion") String nuevaPosicion);

}


