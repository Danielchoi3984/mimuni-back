package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamos")
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idreclamo")
	private Integer idReclamo;
	private String documento;
	private Integer legajo;
	@Column(name = "idsitio")
	private Integer idSitio;
	@Column(name = "iddesperfecto")
	private Integer idDesperfecto;
	private String descripcion;
	private String estado;
	@Column(name = "idreclamounificado")
	private Integer IdReclamoUnificado;

	public Reclamo() {

	}

	public Reclamo(String documento, Integer legajo, Integer idSitio, Integer idDesperfecto, String descripcion,
			String estado, Integer idReclamoUnificado) {
		super();
		this.idReclamo = idReclamo;
		this.documento = documento;
		this.legajo = legajo;
		this.idSitio = idSitio;
		this.idDesperfecto = idDesperfecto;
		this.descripcion = descripcion;
		this.estado = estado;
		IdReclamoUnificado = idReclamoUnificado;
	}

	public Integer getIdReclamo() {
		return idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Integer getIdSitio() {
		return idSitio;
	}

	public void setIdSitio(Integer idSitio) {
		this.idSitio = idSitio;
	}

	public Integer getIdDesperfecto() {
		return idDesperfecto;
	}

	public void setIdDesperfecto(Integer idDesperfecto) {
		this.idDesperfecto = idDesperfecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdReclamoUnificado() {
		return IdReclamoUnificado;
	}

	public void setIdReclamoUnificado(Integer idReclamoUnificado) {
		IdReclamoUnificado = idReclamoUnificado;
	}

	@Override
	public String toString() {
		return "Reclamo [idReclamo=" + idReclamo + ", documento=" + documento + ", legajo=" + legajo + ", idSitio="
				+ idSitio + ", idDesperfecto=" + idDesperfecto + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", IdReclamoUnificado=" + IdReclamoUnificado + "]";
	}

}
