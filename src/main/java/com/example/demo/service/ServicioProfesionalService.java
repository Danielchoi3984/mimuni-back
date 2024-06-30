package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.modelo.ServicioComercio;
import com.example.demo.modelo.ServicioProfesional;
import com.example.demo.modelo.Vecino;
import com.example.demo.modelo.Vecinoregistrado;
import com.example.demo.repository.ServicioProfesionalRepository;
import com.example.demo.repository.VecinoregistradoRepository;

@Service
public class ServicioProfesionalService {

	@Autowired
	ServicioProfesionalRepository repositorioProfesional;

	@Autowired
	VecinoService vecinoService;

	@Autowired
	VecinoregistradoRepository vecinoregistradoRepository;

	public List<ServicioProfesional> serviciosProfesionalesHabilitados() {
		// Servicios todos tiene habilitados y bloqueados
//		List<ServicioProfesional> serviciosTodos =  repositorioProfesional.findAll();
		List<ServicioProfesional> serviciosHabilitados = repositorioProfesional.findByEstado("H");
		return serviciosHabilitados;
	}

	public String crearServicioProfesional(String mail, String medioContacto, String horario, String rubro,
			String descripcion, MultipartFile[] files) {
		Vecino vecino = vecinoService.perfilVecinoregistrado(mail);
		String nombre = vecino.getNombre();
		String apellido = vecino.getApellido();
		Vecinoregistrado vecinoRegistrado = vecinoregistradoRepository.findById(vecino.getDocumento()).get();
		String estado = "B";
		ServicioProfesional servicio = new ServicioProfesional(nombre, apellido, medioContacto, horario, rubro,
				descripcion, vecinoRegistrado, estado);
		repositorioProfesional.save(servicio);
		System.out.println("SERVICIO PROFESIONAL CREADO");
		return "Servicio creado";
	}

	public List<ServicioProfesional> serviciosProfesionales() {
		return repositorioProfesional.findAll();
	}

	public String eliminarServicioProfesional(String mail, Integer idServicioComercio) {
		Vecino vecino = vecinoService.perfilVecinoregistrado(mail);
		if (vecino == null) {
			return "No existe el vecino";
		}
		Optional<ServicioProfesional> servicioProfesionalOptional = repositorioProfesional.findById(idServicioComercio);
		if (servicioProfesionalOptional.isPresent()) {
			ServicioProfesional servicio = servicioProfesionalOptional.get();
			if (servicio.getVecino().getDocumento().equals(vecino.getDocumento())) {
				repositorioProfesional.deleteById(idServicioComercio);
				return "Servicio Profesional eliminado";
			} else {
				return "No es tu Servicio y no lo podes eliminar";
			}
		} else {
			return "No es ID Servicio Comercio";
		}
	}

}