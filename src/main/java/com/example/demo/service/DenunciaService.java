package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.modelo.Denuncia;
import com.example.demo.modelo.DenunciaRecibida;
import com.example.demo.modelo.Sitio;
import com.example.demo.modelo.Vecino;
import com.example.demo.repository.DenunciaRecibidaRepository;
import com.example.demo.repository.DenunciaRepository;
import com.example.demo.repository.VecinoRepository;

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
	DenunciaRecibidaRepository denunciasRecibidaRepository;

	// DEVUELVE TODAS LAS DENUNCIAS
	public List<Denuncia> denuncias() {
		return denunciasRealizasRepository.findAll();
	}

	// DEVUELVE LAS DENUNCIAS QUE HIZO UNA PERSONA
	public List<Denuncia> denunciasRealizadas(String mail) {
		Vecino vecino = vecinoService.perfilVecinoregistrado(mail);
		if (vecino == null) {
			return null;
		} else {

		}
		String documentoRealizoDenuncia = vecino.getDocumento();
		return denunciasRealizasRepository.findByDocumento(documentoRealizoDenuncia);
	}

	public String realizarDenuncia(String mail, String dniDenunciado, Integer idSitio, String descripcion,
			MultipartFile[] files) {
		Vecino vecinoQueHaceDenuncia = vecinoService.perfilVecinoregistrado(mail);
		Optional<Vecino> vecinoQueEsDenunciado = vecinoRepository.findById(dniDenunciado);
		String estado = "Nuevo";
		Integer aceptaResponsabilidad = 1;
		if (vecinoQueEsDenunciado.isPresent()) {
			Sitio sitio = sitioService.buscarSitio(idSitio);
			if (sitio != null) {
				String documentoQueHaceDenuncia = vecinoQueHaceDenuncia.getDocumento();
				Denuncia denuncia = new Denuncia(documentoQueHaceDenuncia, sitio, descripcion, estado,
						aceptaResponsabilidad);

				denunciasRealizasRepository.save(denuncia);
				Integer idDenuncia = ultimaDenuncia().getIdDenuncias();

				Vecino personaDenunciada = vecinoQueEsDenunciado.get();
				DenunciaRecibida denunciaRecibida = new DenunciaRecibida(personaDenunciada, denuncia);
				denunciasRecibidaRepository.save(denunciaRecibida);
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

}
