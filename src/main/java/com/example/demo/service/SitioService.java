package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Sitio;
import com.example.demo.repository.SitioRepository;

@Service
public class SitioService {

	@Autowired
	SitioRepository sitioRepository;

	public List<Sitio> sitios() {
		return sitioRepository.findAll();
	}

	public Sitio buscarSitio(Integer idSitio) {
		Optional<Sitio> sitioOptional = sitioRepository.findById(idSitio);
		if (sitioOptional.isPresent()) {
			Sitio sitio = sitioOptional.get();
			return sitio;
		} else {
			return null;
		}
	}
}
