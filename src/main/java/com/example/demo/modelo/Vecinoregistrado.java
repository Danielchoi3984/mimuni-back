package com.example.demo.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vecinosregistrados")
public class Vecinoregistrado {

	@Id
	private String documento;

	@Basic
	private String mail;

	@Basic
	private String contrasenia;

	@Basic
	private String estado;

	@Column(name = "primeringreso")
	private String primerIngreso;

	public Vecinoregistrado() {

	}

	public Vecinoregistrado(String documento, String mail, String contrasenia, String estado, String primerIngreso) {
		super();
		this.documento = documento;
		this.mail = mail;
		this.contrasenia = contrasenia;
		this.estado = estado;
		this.primerIngreso = primerIngreso;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPrimerIngreso() {
		return primerIngreso;
	}

	public void setPrimerIngreso(String primerIngreso) {
		this.primerIngreso = primerIngreso;
	}

	@Override
	public String toString() {
		return "Vecinoregistrado [documento=" + documento + ", mail=" + mail + ", contrasenia=" + contrasenia
				+ ", estado=" + estado + ", primerIngreso=" + primerIngreso + "]";
	}

}
