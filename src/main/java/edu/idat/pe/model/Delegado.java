package edu.idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Delegado")
public class Delegado {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Delegado")
    private Integer idDelegado;
	
	@Column(name = "Nombre")
	private String nombreDelegado;
	
	@Column(name = "Apellidos")
	private String apellidosDelegado;
	
	@Column(name = "Tipo_Documento")
    private String tipoDocumento;
	
	@Column(name = "Num_Documento")
    private String NumDocumento;
	
	@Column(name = "Telefono")
    private String telefono;
	
	public Delegado() {
	}

	public Delegado(Integer idDelegado, String nombreDelegado, String apellidosDelegado, String tipoDocumento, String numDocumento,
			String telefono) {
		this.idDelegado = idDelegado;
		this.nombreDelegado = nombreDelegado;
		this.apellidosDelegado = apellidosDelegado;
		this.tipoDocumento = tipoDocumento;
		this.NumDocumento = numDocumento;
		this.telefono = telefono;
	}

	public Integer getIdDelegado() {
		return idDelegado;
	}

	public void setIdDelegado(Integer idDelegado) {
		this.idDelegado = idDelegado;
	}

	public String getNombreDelegado() {
		return nombreDelegado;
	}

	public void setNombreDelegado(String nombreDelegado) {
		this.nombreDelegado = nombreDelegado;
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
	
	public String getApellidosDelegado() {
		return apellidosDelegado;
	}

	public void setApellidosDelegado(String apellidosDelegado) {
		this.apellidosDelegado = apellidosDelegado;
	}

}
