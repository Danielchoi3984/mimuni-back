package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		return "Servicio creado";
	}

	public List<ServicioComercio> comercios() {
		return repositorio.findAll();
	}
}
