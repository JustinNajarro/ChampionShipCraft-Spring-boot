package edu.idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Organizador")
public class Organizador {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Organizador")
    private Integer idOrganizador;
	
	@Column(name = "Nombre_Org")
	private String nombreOrganizador;
	
	@Column(name = "Tipo_Documento")
    private String tipoDocumento;
	
	@Column(name = "Num_Documento")
    private String NumDocumento;
	
	@Column(name = "Telefono")
    private String telefono;
	
	public Organizador() {
	}
	
	
	public Organizador(Integer idOrganizador, String nombreOrganizador, String tipoDocumento, String numDocumento,String telefono) {
		this.idOrganizador = idOrganizador;
		this.nombreOrganizador = nombreOrganizador;
		this.tipoDocumento = tipoDocumento;
		this.NumDocumento = numDocumento;
		this.telefono = telefono;
	}



	public Integer getIdOrganizador() {
		return idOrganizador;
	}

	public void setIdOrganizador(Integer idOrganizador) {
		this.idOrganizador = idOrganizador;
	}

	public String getNombreOrganizador() {
		return nombreOrganizador;
	}

	public void setNombreOrganizador(String nombreOrganizador) {
		this.nombreOrganizador = nombreOrganizador;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return NumDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		NumDocumento = numDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}



