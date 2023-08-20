package edu.idat.pe.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TORNEO")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Torneo")
    private Integer idTorneo;
    
    @ManyToOne
    @JoinColumn(name = "ID_Organizador")
    private Organizador organizador;


    @Column(name = "Nombre_Torneo")
    private String nombreTorneo;
    
    @Column(name = "Direccion")
    private String direccion;
    
    @Column(name = "Tipo_Torneo")
    private String tipoTorneo;
    
    @Column(name = "Cantidad_Equipos")
    private Integer cantEquipos;
    
    @Column(name = "Monto_Premio")
    private String montoPremio;
    
    @Column(name = "Goles_Walkover")
    private Integer golesWalkover;
    
    @Column(name = "Estado")
    private String estado;

    @Column(name = "Fecha_Inicio")
    private LocalDateTime fechaInicio;
    
    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuario usuario;

    // Constructor
    public Torneo() {
    }

    public Torneo(Integer idTorneo, Organizador organizador, String nombreTorneo, String direccion, String tipoTorneo, Integer cantEquipos, String montoPremio, Integer golesWalkover, String estado, Usuario usuario,LocalDateTime fechaInicio) {
        this.idTorneo = idTorneo;
        this.organizador = organizador;
        this.nombreTorneo = nombreTorneo;
        this.direccion = direccion;
        this.tipoTorneo = tipoTorneo;
        this.cantEquipos = cantEquipos;
        this.montoPremio = montoPremio;
        this.golesWalkover = golesWalkover;
        this.estado = estado;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoTorneo() {
        return tipoTorneo;
    }

    public void setTipoTorneo(String tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }

    public Integer getCantEquipos() {
        return cantEquipos;
    }

    public void setCantEquipos(Integer cantEquipos) {
        this.cantEquipos = cantEquipos;
    }

    public String getMontoPremio() {
        return montoPremio;
    }

    public void setMontoPremio(String montoPremio) {
        this.montoPremio = montoPremio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
