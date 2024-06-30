package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "datosdenuncia")
public class DatosDenuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String denunciante;
	private String denunciado;

	@Column(name = "iddenuncia")
	private Integer idDenuncia;

	public DatosDenuncia() {

	}

	public DatosDenuncia(String denunciante, String denunciado, Integer idDenuncia) {
		super();
		this.denunciante = denunciante;
		this.denunciado = denunciado;
		this.idDenuncia = idDenuncia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDenunciante() {
		return denunciante;
	}

	public void setDenunciante(String denunciante) {
		this.denunciante = denunciante;
	}

	public String getDenunciado() {
		return denunciado;
	}

	public void setDenunciado(String denunciado) {
		this.denunciado = denunciado;
	}

	public Integer getIdDenuncia() {
		return idDenuncia;
	}

	public void setIdDenuncia(Integer idDenuncia) {
		this.idDenuncia = idDenuncia;
	}

	@Override
	public String toString() {
		return "DatosDenuncia [id=" + id + ", denunciante=" + denunciante + ", denunciado=" + denunciado
				+ ", idDenuncia=" + idDenuncia + "]";
	}

}
