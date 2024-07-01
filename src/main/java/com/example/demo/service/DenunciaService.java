package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.UploadFilesServiceDenuncias;
import com.example.demo.modelo.DatosDenuncia;
import com.example.demo.modelo.Denuncia;
import com.example.demo.modelo.Sitio;
import com.example.demo.modelo.Vecino;
import com.example.demo.repository.DatosDenunciaRepository;
import com.example.demo.repository.DenunciaRepository;
import com.example.demo.repository.VecinoRepository;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Service
public class DenunciaService {

	@Autowired
	DenunciaRepository denunciasRealizasRepository;

	@Autowired
	VecinoService vecinoService;

	@Autowired
	VecinoRepository vecinoRepository;

	@Autowired
	SitioService sitioService;

	@Autowired
	UploadFilesServiceDenuncias guardarImagenes;

	@Autowired
	DatosDenunciaRepository datosDenunciaRepository;

	// DEVUELVE TODAS LAS DENUNCIAS
	public List<Denuncia> denuncias() {
		return denunciasRealizasRepository.findAll();
	}

//	// DEVUELVE LAS DENUNCIAS QUE HIZO UNA PERSONA
	public List<Denuncia> denunciasRealizadas(String mail) {
		Vecino vecino = vecinoService.perfilVecinoregistrado(mail);
		if (vecino == null) {
			return null;
		} else {

			List<DatosDenuncia> datosDenuncia = datosDenunciaRepository.findAll();
			List<Integer> idDenunciasRealiazadas = new ArrayList<>();
			for (DatosDenuncia datos : datosDenuncia) {
				if (datos.getDenunciante().equals(vecino.getDocumento())) {
					idDenunciasRealiazadas.add(datos.getIdDenuncia());
				}
			}

			List<Denuncia> denuncias = new ArrayList<>();
			for (Integer id : idDenunciasRealiazadas) {
				denuncias.add(denunciasRealizasRepository.findById(id).get());
			}
			return denuncias;
		}

	}

	public String realizarDenuncia(String mail, String dniDenunciado, Integer idSitio, String descripcion,
			MultipartFile[] files) {

		Vecino vecinoQueHaceDenuncia = vecinoService.perfilVecinoregistrado(mail);

		Optional<Vecino> vecinoQueEsDenunciado = vecinoRepository.findById(dniDenunciado);

		if (vecinoQueEsDenunciado.isPresent()) {
			Sitio sitio = sitioService.buscarSitio(idSitio);
			if (sitio != null) {

				String documentoDenunciado = vecinoQueEsDenunciado.get().getDocumento();
				String estado = "Nuevo";
				Integer aceptaResponsabilidad = 1;
				Denuncia denuncia = new Denuncia(dniDenunciado, sitio, descripcion, estado, aceptaResponsabilidad);

				denunciasRealizasRepository.save(denuncia);
				Integer idDenuncia = ultimaDenuncia().getIdDenuncias();

				String documentoDenunciante = vecinoQueHaceDenuncia.getDocumento();
				DatosDenuncia datosDenuncia = new DatosDenuncia(documentoDenunciante, documentoDenunciado, idDenuncia);

				datosDenunciaRepository.save(datosDenuncia);

//				Hay que buscar la ultima denuncia
				Denuncia ultima = ultimaDenuncia();
				Integer numDenuncia = ultima.getIdDenuncias();
				guardarImagenes.handleFileUpload(numDenuncia, files);

				return "Tu numero de denuncia es " + idDenuncia;
				// Aca hay que hacer algo con las fotos tambien

			} else {
				return "No existe ese sitio";
			}

		} else {
			return "No hay vecinos con ese documento";
		}

	}

	public Denuncia ultimaDenuncia() {
		List<Denuncia> denuncias = denunciasRealizasRepository.findAll();
		Denuncia ultimaDenuncia = null;
		for (Denuncia denuncia : denuncias) {
			ultimaDenuncia = denuncia;
		}
		return ultimaDenuncia;
	}

	public List<Denuncia> denunciasRecibidas(String mail) {
		Vecino vecino = vecinoService.perfilVecinoregistrado(mail);
		if (vecino == null) {
			return null;
		} else {
			String documentoRealizoDenuncia = vecino.getDocumento();
			return denunciasRealizasRepository.findByDocumento(documentoRealizoDenuncia);
		}
	}

}
