package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenesreclamos")
public class ImagenReclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idimagen")
	private Integer idImagen;
	private String path;
	@Column(name = "idreclamo")
	private Integer idReclamo;

	public ImagenReclamo() {

	}

	public ImagenReclamo(String path, Integer idReclamo) {
		super();
		this.idImagen = idImagen;
		this.path = path;
		this.idReclamo = idReclamo;
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

	public Integer getIdReclamo() {
		return idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	@Override
	public String toString() {
		return "ImagenReclamo [idImagen=" + idImagen + ", path=" + path + ", idReclamo=" + idReclamo + "]";
	}

}
