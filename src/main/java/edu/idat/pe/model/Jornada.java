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
@Table(name = "Jornada")
public class Jornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Jornada")
    private Integer idJornada;
	
    @ManyToOne
    @JoinColumn(name = "ID_Fixture")
    private Fixture fixture;
	
    @Column(name = "Num_Fecha")
    private Integer numFecha;
	
    @Column(name = "Cant_Encuentros")
    private Integer cantEncuentros;
	
	public Jornada() {
		
	}

	public Jornada(Integer idJornada, Fixture fixture, Integer numFecha, Integer cantEncuentros) {
		this.idJornada = idJornada;
		this.fixture = fixture;
		this.numFecha = numFecha;
		this.cantEncuentros = cantEncuentros;
	}

	public Integer getIdJornada() {
		return idJornada;
	}

	public void setIdJornada(Integer idJornada) {
		this.idJornada = idJornada;
	}

	public Fixture getFixture() {
		return fixture;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}

	public Integer getNumFecha() {
		return numFecha;
	}

	public void setNumFecha(Integer numFecha) {
		this.numFecha = numFecha;
	}

	public Integer getCantEncuentros() {
		return cantEncuentros;
	}

	public void setCantEncuentros(Integer cantEncuentros) {
		this.cantEncuentros = cantEncuentros;
	}

	
}
