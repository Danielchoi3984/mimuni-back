package com.example.demo.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientosdenuncia")
public class MovimientoDenuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmovimiento")
	private Integer idMovimiento;

	@Column(name = "iddenuncia")
	private Integer idDenuncia;

	@Column(name = "responsable")
	private String responsable;

	@Column(name = "causa", length = 1000)
	private String causa;

	@Column(name = "fecha", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime fecha;

	public MovimientoDenuncia() {

	}

	public MovimientoDenuncia(Integer idDenuncia, String responsable, String causa, LocalDateTime fecha) {
		super();
		this.idDenuncia = idDenuncia;
		this.responsable = responsable;
		this.causa = causa;
		this.fecha = fecha;
	}

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Integer getIddeclamo() {
		return idDenuncia;
	}

	public void setIddeclamo(Integer iddeclamo) {
		this.idDenuncia = iddeclamo;
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
		return "MovimientoDenuncia [idMovimiento=" + idMovimiento + ", iddeclamo=" + idDenuncia + ", responsable="
				+ responsable + ", causa=" + causa + ", fecha=" + fecha + "]";
	}

}
