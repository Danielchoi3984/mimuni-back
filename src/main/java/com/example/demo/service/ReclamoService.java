package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.UploadFilesService;
import com.example.demo.modelo.Desperfecto;
import com.example.demo.modelo.MovimientoReclamo;
import com.example.demo.modelo.Personal;
import com.example.demo.modelo.Reclamo;
import com.example.demo.modelo.Sitio;
import com.example.demo.modelo.Vecino;
import com.example.demo.repository.ImagenReclamoRepository;
import com.example.demo.repository.MovimientoReclamoRepository;
import com.example.demo.repository.PersonalRepository;
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

	@Autowired
	UploadFilesService guardarImagenes;

	@Autowired
	MovimientoReclamoRepository movimientoReclamoRepository;

	@Autowired
	PersonalService personalService;

	@Autowired
	PersonalRepository personalRepository;

	public List<Reclamo> todosLosReclamos() {
		return reclamoRepository.findAll();
	}

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

					reclamoRepository.save(nuevoReclamo);

					Reclamo r = ultimoReclamo();
					guardarImagenes.handleFileUpload(r.getIdReclamo(), files);

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

	public Reclamo ultimoReclamo() {
		List<Reclamo> reclamos = reclamoRepository.findAll();
		Reclamo reclamo = null;
		for (Reclamo r : reclamos) {
			reclamo = r;
		}
		return reclamo;
	}

	public List<Reclamo> misReclamosVecino(String mail) {
		Vecino vecino = vecinoservice.perfilVecinoregistrado(mail);
		List<Reclamo> reclamos = reclamoRepository.findAll();
		List<Reclamo> misReclamos = new ArrayList<>();
		for (Reclamo reclamo : reclamos) {
			if (reclamo.getDocumento().equals(vecino.getDocumento())) {
				misReclamos.add(reclamo);
			}
		}
		return misReclamos;
	}

	public List<MovimientoReclamo> movimientosReclamo(Integer idReclamo) {
		return movimientoReclamoRepository.findByIdReclamo(idReclamo);
	}

	public String generarReclamoInspector(Integer legajo, Integer idSitio, Integer idDesperfecto, String descripcion,
			MultipartFile[] files) {
		Optional<Personal> personalOptional = personalRepository.findById(legajo);
		if (personalOptional.isPresent()) {
			Personal inspector = personalOptional.get();
			if (inspector.getCategoria() == 8) {
				// Validamos sitio
				Sitio sitio = sitioService.buscarSitio(idSitio);
				if (sitio != null) {
					// Validamos desperfecto
					Desperfecto desperfecto = desperfectoService.buscarDesperfectoId(idDesperfecto);
					if (desperfecto != null) {
						String estado = "Nuevo";

						Reclamo nuevoReclamo = new Reclamo(null, legajo, idSitio, idDesperfecto, descripcion, estado,
								null);

						reclamoRepository.save(nuevoReclamo);

						Reclamo r = ultimoReclamo();
						guardarImagenes.handleFileUpload(r.getIdReclamo(), files);
						return "Tu numero de reclamo es " + r.getIdReclamo();

					} else {
						return "No existe ID desperfecto";
					}
				} else {
					return "No existe ID sitio";
				}

			} else {
				return "Sos empleado municipal pero no inspector";
			}

		} else {
			return "NO SOS EMPLEADO MUNICIPAL";
		}

	}

}
