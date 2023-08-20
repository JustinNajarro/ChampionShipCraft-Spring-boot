package edu.idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Encuentro")
public class Encuentro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Encuentro")
	private Integer idEncuentro;
	
	@ManyToOne
    @JoinColumn(name = "ID_Jornada")
    private Jornada idJornada;
	
	@ManyToOne
    @JoinColumn(name = "ID_Equipo_Local")
    private Equipo idEquipoLocal;
	
	@ManyToOne
    @JoinColumn(name = "ID_Equipo_Visita")
    private Equipo idEquipoVisita;
	
	@Column(name = "Equipo_Local")
    private String equipoLocal;
	
	@Column(name = "Equipo_Visita")
    private String equipoVisita;
	
	@Column(name = "Goles_Local")
	private Integer golesLocal;
	
	@Column(name = "Goles_Visita")
	private Integer golesVisita;
	
	@Column(name = "Estado")
    private String estado;

	@Column(name = "Fecha_Encuentro")
	private LocalDateTime fechaEncuentro;
	
	public Encuentro() {
			
		}

	public Encuentro(Integer idEncuentro, Jornada idJornada, Equipo idEquipoLocal, Equipo idEquipoVisita,
			String equipoLocal, String equipoVisita, Integer golesLocal, Integer golesVisita, String estado, LocalDateTime fechaEncuentro) {
		super();
		this.idEncuentro = idEncuentro;
		this.idJornada = idJornada;
		this.idEquipoLocal = idEquipoLocal;
		this.idEquipoVisita = idEquipoVisita;
		this.equipoLocal = equipoLocal;
		this.equipoVisita = equipoVisita;
		this.golesLocal = golesLocal;
		this.golesVisita = golesVisita;
		this.estado = estado;
		this.fechaEncuentro = fechaEncuentro;
	}

	public Integer getIdEncuentro() {
		return idEncuentro;
	}

	public void setIdEncuentro(Integer idEncuentro) {
		this.idEncuentro = idEncuentro;
	}

	public Jornada getIdJornada() {
		return idJornada;
	}

	public void setIdJornada(Jornada idJornada) {
		this.idJornada = idJornada;
	}

	public Equipo getIdEquipoLocal() {
		return idEquipoLocal;
	}

	public void setIdEquipoLocal(Equipo idEquipoLocal) {
		this.idEquipoLocal = idEquipoLocal;
	}

	public Equipo getIdEquipoVisita() {
		return idEquipoVisita;
	}

	public void setIdEquipoVisita(Equipo idEquipoVisita) {
		this.idEquipoVisita = idEquipoVisita;
	}

	public String getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public String getEquipoVisita() {
		return equipoVisita;
	}

	public void setEquipoVisita(String equipoVisita) {
		this.equipoVisita = equipoVisita;
	}

	public Integer getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(Integer golesLocal) {
		this.golesLocal = golesLocal;
	}

	public Integer getGolesVisita() {
		return golesVisita;
	}

	public void setGolesVisita(Integer golesVisita) {
		this.golesVisita = golesVisita;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaEncuentro() {
		return fechaEncuentro;
	}

	public void setFechaEncuentro(LocalDateTime fechaEncuentro) {
		this.fechaEncuentro = fechaEncuentro;
	}
}
