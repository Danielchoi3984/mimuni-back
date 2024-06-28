package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Barrio;
import com.example.demo.repository.BarrioRepository;

@Service
public class BarrioService {

	@Autowired
	BarrioRepository repositorio;

//	FALTA ENDPOINT
	public List<Barrio> barrios() {
		return repositorio.findAll();
	}

//	FALTA ENDPOINT
	public Barrio barrioId(Integer idBarrio) {
		Optional<Barrio> barrioOptional = repositorio.findById(idBarrio);
		if (barrioOptional.isPresent()) {
//			Si encontro el barrio lo devolvemos
			Barrio barrio = barrioOptional.get();
			return barrio;
		} else {
//			Si no encontro el barrio devolvemos null
			return null;
		}
	}

//	No se usa en el front, solo en el back para ver que los traiga
	public void mostrarBarrios() {
		List<Barrio> barrios = repositorio.findAll();
		for (Barrio barrio : barrios) {
			System.out.println(barrio);
		}
	}
}
