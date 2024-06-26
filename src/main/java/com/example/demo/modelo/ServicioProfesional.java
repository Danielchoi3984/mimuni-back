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
@Table(name = "serviciosprofesionales")
public class ServicioProfesional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idservicioprofesional;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "contacto")
	private String contacto;

	@Column(name = "horario")
	private String horario;

	@Column(name = "rubro")
	private String rubro;

	@Column(name = "descripcion")
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "documento", referencedColumnName = "documento", nullable = false)
	private Vecinoregistrado vecino;

	@Column(name = "estado")
	private String estado;

	public ServicioProfesional() {

	}

	public ServicioProfesional(String nombre, String apellido, String contacto, String horario, String rubro,
			String descripcion, Vecinoregistrado vecino, String estado) {
		super();
		this.idservicioprofesional = idservicioprofesional;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contacto = contacto;
		this.horario = horario;
		this.rubro = rubro;
		this.descripcion = descripcion;
		this.vecino = vecino;
		this.estado = estado;
	}

	public Integer getIdservicioprofesional() {
		return idservicioprofesional;
	}

	public void setIdservicioprofesional(Integer idservicioprofesional) {
		this.idservicioprofesional = idservicioprofesional;
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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Vecinoregistrado getVecino() {
		return vecino;
	}

	public void setVecino(Vecinoregistrado vecino) {
		this.vecino = vecino;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ServicioProfesional [idservicioprofesional=" + idservicioprofesional + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", contacto=" + contacto + ", horario=" + horario + ", rubro=" + rubro
				+ ", descripcion=" + descripcion + ", vecino=" + vecino + ", estado=" + estado + "]";
	}

}
