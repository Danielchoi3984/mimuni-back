package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenesserviciosprofesionales")
public class ImagenServicioProfesional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idimagen")
	private Integer idImagen;

	private String path;

	@Column(name = "idservicioprofesional")
	private Integer idservicioprofesional;

	public ImagenServicioProfesional() {

	}

	public ImagenServicioProfesional(String path, Integer idservicioprofesional) {
		super();
		this.path = path;
		this.idservicioprofesional = idservicioprofesional;
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

	public Integer getIdservicioprofesional() {
		return idservicioprofesional;
	}

	public void setIdservicioprofesional(Integer idservicioprofesional) {
		this.idservicioprofesional = idservicioprofesional;
	}

	@Override
	public String toString() {
		return "ImagenServicioProfesional [idImagen=" + idImagen + ", path=" + path + ", idservicioprofesional="
				+ idservicioprofesional + "]";
	}

}
