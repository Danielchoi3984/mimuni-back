package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.modelo.Desperfecto;
import com.example.demo.modelo.Reclamo;
import com.example.demo.modelo.Sitio;
import com.example.demo.modelo.Vecino;
import com.example.demo.repository.ImagenReclamoRepository;
import com.example.demo.repository.ReclamoRepository;

@Service
public class ReclamoService {

	@Autowired
	ReclamoRepository reclamoRepository;

	@Autowired
	ImagenReclamoRepository imagenReclamoRepository;

	@Autowired
	VecinoService vecinoservice;

	@Autowired
	SitioService sitioService;

	@Autowired
	DesperfectoService desperfectoService;

	public String generarReclamoVecino(String mail, Integer idSitio, Integer idDesperfecto, String descripcion,
			MultipartFile[] files) {
//		Aca tenemsos el documento
		Vecino vecino = vecinoservice.perfilVecinoregistrado(mail);
		if (vecino != null) {
			// Validamos el sitio
			Sitio sitio = sitioService.buscarSitio(idSitio);
			if (sitio != null) {
				// Validamos desperfecto
				Desperfecto desperfecto = desperfectoService.buscarDesperfectoId(idDesperfecto);
				if (desperfecto != null) {
					String documento = vecino.getDocumento();
					Reclamo nuevoReclamo = new Reclamo(documento, null, idSitio, idDesperfecto, descripcion, "Nuevo",
							null);
					// Falta guardar las imagenes
					// Falta guardar las imagenes
					// Falta guardar las imagenes
					// Falta guardar las imagenes
					// Falta guardar las imagenes
					reclamoRepository.save(nuevoReclamo);
					
					return "Reclamo generado con exito";

				} else {
					return "Desperfecto no encontrado";
				}

			} else {
				return "Sitio no encontrado";
			}
		} else {
			return "Vecino no encontrado";
		}
	}

}
