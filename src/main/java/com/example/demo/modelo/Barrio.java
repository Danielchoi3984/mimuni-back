package com.example.demo.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "barrios")
public class Barrio {

	@Id
	private Integer idbarrio;
	@Basic
	private String nombre;

	public Barrio() {

	}

	public Barrio(Integer idbarrio, String nombre) {
		this.idbarrio = idbarrio;
		this.nombre = nombre;
	}

	public Integer getIdbarrio() {
		return idbarrio;
	}

	public void setIdbarrio(Integer idbarrio) {
		this.idbarrio = idbarrio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Barrio [idbarrio=" + idbarrio + ", nombre=" + nombre + "]";
	}

}
