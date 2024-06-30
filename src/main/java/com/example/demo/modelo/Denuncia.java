package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "denuncias")
public class Denuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddenuncias")
	private Integer idDenuncias;

	@Column(name = "documento", nullable = false)
	private String documento;

	@ManyToOne
	@JoinColumn(name = "idsitio")
	private Sitio sitio;

	@Column(name = "descripcion", length = 2000)
	private String descripcion;

	@Column(name = "estado", length = 150)
	private String estado;

	@Column(name = "aceptaresponsabilidad", nullable = false)
	private Integer aceptaResponsabilidad;

	public Denuncia() {

	}

	public Denuncia(String documento, Sitio sitio, String descripcion, String estado, Integer aceptaResponsabilidad) {
		super();
		this.documento = documento;
		this.sitio = sitio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.aceptaResponsabilidad = aceptaResponsabilidad;
	}

	public Integer getIdDenuncias() {
		return idDenuncias;
	}

	public void setIdDenuncias(Integer idDenuncias) {
		this.idDenuncias = idDenuncias;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Sitio getSitio() {
		return sitio;
	}

	public void setSitio(Sitio sitio) {
		this.sitio = sitio;
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

	public Integer getAceptaResponsabilidad() {
		return aceptaResponsabilidad;
	}

	public void setAceptaResponsabilidad(Integer aceptaResponsabilidad) {
		this.aceptaResponsabilidad = aceptaResponsabilidad;
	}

	@Override
	public String toString() {
		return "Denuncia [idDenuncias=" + idDenuncias + ", documento=" + documento + ", sitio=" + sitio
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", aceptaResponsabilidad="
				+ aceptaResponsabilidad + "]";
	}

}
