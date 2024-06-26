package com.example.demo.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vecinos")
public class Vecino {
	@Id
	private String documento;
	@Basic
	private String nombre;
	@Basic
	private String apellido;
	@Basic
	private String direccion;

	@Basic
	private Integer codigobarrio;

	public Vecino() {

	}

	public Vecino(String documento, String nombre, String apellido, String direccion, Integer codigobarrio) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.codigobarrio = codigobarrio;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getCodigobarrio() {
		return codigobarrio;
	}

	public void setCodigobarrio(Integer codigobarrio) {
		this.codigobarrio = codigobarrio;
	}

	@Override
	public String toString() {
		return "Vecino [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + ", codigobarrio=" + codigobarrio + "]";
	}

}
