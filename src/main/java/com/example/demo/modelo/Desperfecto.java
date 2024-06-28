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
@Table(name = "desperfectos")
public class Desperfecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddesperfecto")
	private Integer idDesperfecto;

	@Column(name = "descripcion")
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "idrubro")
	private Rubro rubro;

	public Desperfecto() {

	}

	public Desperfecto(Integer idDesperfecto, String descripcion, Rubro rubro) {
		super();
		this.idDesperfecto = idDesperfecto;
		this.descripcion = descripcion;
		this.rubro = rubro;
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

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	@Override
	public String toString() {
		return "Desperfecto [idDesperfecto=" + idDesperfecto + ", descripcion=" + descripcion + ", rubro=" + rubro
				+ "]";
	}

}
