package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.UploadFilesServiceComercio;
import com.example.demo.UploadFilesServiceDenuncias;
import com.example.demo.modelo.ServicioComercio;
import com.example.demo.modelo.Vecino;
import com.example.demo.modelo.Vecinoregistrado;
import com.example.demo.repository.ServicioComercioRepository;
import com.example.demo.repository.VecinoregistradoRepository;

@Service
public class ServicioComercioService {
	@Autowired
	ServicioComercioRepository repositorio;

	@Autowired
	VecinoregistradoRepository vecinoregistradoRepository;

	@Autowired
	VecinoService vecinoService;

	@Autowired
	UploadFilesServiceComercio guardarImagenes;

	public List<ServicioComercio> serviciosComerciosHabilitados() {
		List<ServicioComercio> comerciosHabilitados = repositorio.findByEstado("H");
		return comerciosHabilitados;
	}

	public String crearServicioComercio(String mail, String direccion, String contacto, String descripcion,
			MultipartFile[] files) {
		String estado = "B";
		Vecino vecino = vecinoService.perfilVecinoregistrado(mail);
		Vecinoregistrado vecinoregistrado = vecinoregistradoRepository.findById(vecino.getDocumento()).get();
		ServicioComercio servicio = new ServicioComercio(direccion, contacto, descripcion, vecinoregistrado, estado);
		repositorio.save(servicio);

//		Aca agreamos la imagen
		ServicioComercio ultimoServicioComercio = ultimoServicioComercio();
		Integer idUltimo = ultimoServicioComercio.getIdServicioComercio();
		guardarImagenes.handleFileUpload(idUltimo, files);

		return "Servicio creado";
	}

	public List<ServicioComercio> comercios() {
		return repositorio.findAll();
	}

	public String eliminarServicioComercio(String mail, Integer idServicioComercio) {
		Vecino vecino = vecinoService.perfilVecinoregistrado(mail);
		if (vecino == null) {
			return "No existe el vecino";
		}
		Optional<ServicioComercio> servicioComercioOptional = repositorio.findById(idServicioComercio);
		if (servicioComercioOptional.isPresent()) {
			ServicioComercio servicio = servicioComercioOptional.get();
			if (servicio.getVecino().getDocumento().equals(vecino.getDocumento())) {
				repositorio.deleteById(idServicioComercio);
				return "Servicio Comercio eliminado";
			} else {
				return "No es tu Servicio y no lo podes eliminar";
			}
		} else {
			return "No es ID Servicio Profesional";
		}
	}

	public ServicioComercio ultimoServicioComercio() {
		List<ServicioComercio> comercios = repositorio.findAll();
		ServicioComercio ultimo = null;
		for (ServicioComercio servicio : comercios) {
			ultimo = servicio;
		}
		return ultimo;

	}
}
