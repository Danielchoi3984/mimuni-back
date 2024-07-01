package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenesservicioscomercios")
public class ImagenServicioComercio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idimagen")
	private Integer idImagen;

	private String path;

	@Column(name = "idserviciocomercio")
	private Integer idserviciocomercio;

	public ImagenServicioComercio() {

	}

	public ImagenServicioComercio(String path, Integer idserviciocomercio) {
		super();
		this.path = path;
		this.idserviciocomercio = idserviciocomercio;
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

	public Integer getIdserviciocomercio() {
		return idserviciocomercio;
	}

	public void setIdserviciocomercio(Integer idserviciocomercio) {
		this.idserviciocomercio = idserviciocomercio;
	}

	@Override
	public String toString() {
		return "ImagenServicioComercio [idImagen=" + idImagen + ", path=" + path + ", idserviciocomercio="
				+ idserviciocomercio + "]";
	}

}
