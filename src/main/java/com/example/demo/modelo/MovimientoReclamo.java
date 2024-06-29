package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimientosreclamo")
public class MovimientoReclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmovimiento")
	private Integer idMovimiento;

	@Column(name = "idreclamo")
	private Integer idReclamo;

	@Column(name = "responsable")
	private String responsable;

	@Column(name = "causa", length = 1000)
	private String causa;

	@Column(name = "fecha", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime fecha;

	// Constructor vacío requerido por JPA
	public MovimientoReclamo() {
	}

	public MovimientoReclamo(Integer idReclamo, String responsable, String causa, LocalDateTime fecha) {
		super();
		this.idMovimiento = idMovimiento;
		this.idReclamo = idReclamo;
		this.responsable = responsable;
		this.causa = causa;
		this.fecha = fecha;
	}

	// Getters y setters

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Integer getIdReclamo() {
		return idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "MovimientoReclamo [idMovimiento=" + idMovimiento + ", idReclamo=" + idReclamo + ", responsable="
				+ responsable + ", causa=" + causa + ", fecha=" + fecha + "]";
	}

}
