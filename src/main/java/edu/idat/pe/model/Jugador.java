package edu.idat.pe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Jugador")
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Jugador")
    private Integer idJugador;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Apellidos")
    private String apellido;
    
    @Column(name = "Tipo_Documento")
    private String tipoDocumento;
    
    @Column(name = "Num_Documento")
    private String numDocumento;
    
    @Column(name = "Num_Camiseta")
    private int numCamiseta;
    
    @Column(name = "Posicion")
    private String posicion;
    
    @ManyToOne
    @JoinColumn(name = "ID_Equipo")
    private Equipo equipo;
    
    public Jugador() {
        
    }
  
    public Jugador(Integer idJugador, String nombre, String apellido, String tipoDocumento,String numDocumento, int numCamiseta, String posicion, Equipo equipo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento=tipoDocumento;
        this.numDocumento = numDocumento;
        this.numCamiseta = numCamiseta;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    // Getters
    public Integer getIdJugador() {
        return idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public String getTipoDocumento() {
    	return tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    // Setters
    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setTipoDocumento(String tipoDocumento) {
    	this.tipoDocumento = tipoDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public void setNumCamiseta(int numCamiseta) {
        this.numCamiseta = numCamiseta;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
