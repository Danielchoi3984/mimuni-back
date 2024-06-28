package com.example.demo.modelo;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sitios")
public class Sitio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idsitio")
	private Integer idSitio;

	private Double latitud;
	private Double longitud;
	private String calle;
	private Integer numero; // Es la altura
	
	@Column(name = "entrecallea")
	private String entreCalleA;
	@Column(name = "entrecalleb")
	private String entreCalleB;
	private String descripcion;
	@Column(name = "acargode")
	private String aCargoDe;
	private LocalTime apertura;
	private LocalTime cierre;
	private String comentarios;

	public Sitio() {

	}

	public Sitio(Integer idSitio, Double latitud, Double longitud, String calle, Integer numero, String entreCalleA,
			String entreCalleB, String descripcion, String aCargoDe, LocalTime apertura, LocalTime cierre,
			String comentarios) {
		super();
		this.idSitio = idSitio;
		this.latitud = latitud;
		this.longitud = longitud;
		this.calle = calle;
		this.numero = numero;
		this.entreCalleA = entreCalleA;
		this.entreCalleB = entreCalleB;
		this.descripcion = descripcion;
		this.aCargoDe = aCargoDe;
		this.apertura = apertura;
		this.cierre = cierre;
		this.comentarios = comentarios;
	}

	public Integer getIdSitio() {
		return idSitio;
	}

	public void setIdSitio(Integer idSitio) {
		this.idSitio = idSitio;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEntreCalleA() {
		return entreCalleA;
	}

	public void setEntreCalleA(String entreCalleA) {
		this.entreCalleA = entreCalleA;
	}

	public String getEntreCalleB() {
		return entreCalleB;
	}

	public void setEntreCalleB(String entreCalleB) {
		this.entreCalleB = entreCalleB;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getaCargoDe() {
		return aCargoDe;
	}

	public void setaCargoDe(String aCargoDe) {
		this.aCargoDe = aCargoDe;
	}

	public LocalTime getApertura() {
		return apertura;
	}

	public void setApertura(LocalTime apertura) {
		this.apertura = apertura;
	}

	public LocalTime getCierre() {
		return cierre;
	}

	public void setCierre(LocalTime cierre) {
		this.cierre = cierre;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Sitio [idSitio=" + idSitio + ", latitud=" + latitud + ", longitud=" + longitud + ", calle=" + calle
				+ ", numero=" + numero + ", entreCalleA=" + entreCalleA + ", entreCalleB=" + entreCalleB
				+ ", descripcion=" + descripcion + ", aCargoDe=" + aCargoDe + ", apertura=" + apertura + ", cierre="
				+ cierre + ", comentarios=" + comentarios + "]";
	}

}
