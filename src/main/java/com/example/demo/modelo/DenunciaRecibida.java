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
@Table(name = "denunciasrecibidas")
public class DenunciaRecibida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "personadenunciada", nullable = false)
	private Vecino personadenunciada;

	@ManyToOne
	@JoinColumn(name = "iddenuncia", nullable = false)
	private Denuncia idDenuncia;

	public DenunciaRecibida() {

	}

	public DenunciaRecibida(Vecino personadenunciada, Denuncia idDenuncia) {
		super();
		this.personadenunciada = personadenunciada;
		this.idDenuncia = idDenuncia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Vecino getPersonadenunciada() {
		return personadenunciada;
	}

	public void setPersonadenunciada(Vecino personadenunciada) {
		this.personadenunciada = personadenunciada;
	}

	public Denuncia getIdDenuncia() {
		return idDenuncia;
	}

	public void setIdDenuncia(Denuncia idDenuncia) {
		this.idDenuncia = idDenuncia;
	}

	@Override
	public String toString() {
		return "DenunciaRecibida [id=" + id + ", personadenunciada=" + personadenunciada + ", idDenuncia=" + idDenuncia
				+ "]";
	}

}
