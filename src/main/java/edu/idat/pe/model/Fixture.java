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
@Table(name = "Fixture")
public class Fixture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Fixture")
    private Integer idFixture;
	
	@ManyToOne
    @JoinColumn(name = "ID_Torneo")
    private Torneo torneo;
	
	@Column(name = "Cant_Jornadas")
    private Integer cantJornadas;
	
	public Fixture() {
		
	}

	public Fixture(Integer idFixture, Torneo torneo, Integer cantJornadas) {
		this.idFixture = idFixture;
		this.torneo = torneo;
		this.cantJornadas = cantJornadas;
	}

	public Integer getIdFixture() {
		return idFixture;
	}

	public void setIdFixture(Integer idFixture) {
		this.idFixture = idFixture;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Integer getCanJornadas() {
		return cantJornadas;
	}

	public void setCanJornadas(Integer cantJornadas) {
		this.cantJornadas = cantJornadas;
	}
	
	
}
