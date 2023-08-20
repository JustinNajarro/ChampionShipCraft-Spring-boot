package edu.idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Equipo")
public class Equipo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Equipo")
    private Integer idEquipo;
	
	@Column(name = "Nombre_Equipo")
    private String nomEquipo;
	
	@Column(name = "Nombre_corto")
    private String nomEquipoCorto;
	
	@Column(name = "Ciudad")
	private String ciudad;
	
	@ManyToOne
    @JoinColumn(name = "ID_Delegado")
    private Delegado delegado;
	
	@ManyToOne
    @JoinColumn(name = "ID_Torneo")
    private Torneo torneo;
	
	public Equipo() {
		
	}
	
	public Equipo(Integer idEquipo, String nomEquipo, String nomEquipoCorto, String ciudad, Delegado delegado,
			Torneo torneo) {
		this.idEquipo = idEquipo;
		this.nomEquipo = nomEquipo;
		this.nomEquipoCorto = nomEquipoCorto;
		this.ciudad = ciudad;
		this.delegado = delegado;
		this.torneo = torneo;
	}

	public Integer getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNomEquipo() {
		return nomEquipo;
	}

	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}

	public String getNomEquipoCorto() {
		return nomEquipoCorto;
	}

	public void setNomEquipoCorto(String nomEquipoCorto) {
		this.nomEquipoCorto = nomEquipoCorto;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Delegado getDelegado() {
		return delegado;
	}

	public void setDelegado(Delegado delegado) {
		this.delegado = delegado;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	
}
