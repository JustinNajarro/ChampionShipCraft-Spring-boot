package edu.idat.pe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class TablaPosiciones {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nombreEquipo;
	//Partidos Jugados
	private int pj;
	//Puntos
	private int puntos;
	//Partido ganados
	private int g;
	//Partidos perdidos
	private int p;
	//Partidos empatados
	private int e;
	//Goles a favor
	private int gf;
	//Goles en contra
	private int gc;
	//Direncia de goles
	private int df;
	
	public TablaPosiciones() {
		
	}
	
	public TablaPosiciones(String nombreEquipo, int pj, int puntos, int g, int p, int e, int gf, int gc,
			int df) {

		this.nombreEquipo = nombreEquipo;
		this.pj = pj;
		this.puntos = puntos;
		this.g = g;
		this.p = p;
		this.e = e;
		this.gf = gf;
		this.gc = gc;
		this.df = df;
	}


	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getPj() {
		return pj;
	}

	public void setPj(int pj) {
		this.pj = pj;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getGf() {
		return gf;
	}

	public void setGf(int gf) {
		this.gf = gf;
	}

	public int getGc() {
		return gc;
	}

	public void setGc(int gc) {
		this.gc = gc;
	}

	public int getDf() {
		return df;
	}

	public void setDf(int df) {
		this.df = df;
	}
	
	
}
