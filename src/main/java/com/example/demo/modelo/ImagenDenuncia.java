package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenesdenuncias")
public class ImagenDenuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idimagen")
	private Integer idImagen;

	private String path;

	@Column(name = "iddenuncia")
	private Integer idDenuncia;

	public ImagenDenuncia() {

	}

	public ImagenDenuncia(String path, Integer idDenuncia) {
		super();
		this.idImagen = idImagen;
		this.path = path;
		this.idDenuncia = idDenuncia;
	}

	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getIdDenuncia() {
		return idDenuncia;
	}

	public void setIdDenuncia(Integer idDenuncia) {
		this.idDenuncia = idDenuncia;
	}

	@Override
	public String toString() {
		return "ImagenDenuncia [idImagen=" + idImagen + ", path=" + path + ", idDenuncia=" + idDenuncia + "]";
	}

}
