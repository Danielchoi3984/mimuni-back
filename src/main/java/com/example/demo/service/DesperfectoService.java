package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Desperfecto;
import com.example.demo.modelo.Personal;
import com.example.demo.repository.DesperfectoRepository;
import com.example.demo.repository.PersonalRepository;

@Service
public class DesperfectoService {

	@Autowired
	DesperfectoRepository desperfectoRepository;

	@Autowired
	PersonalService personalService;

	public List<Desperfecto> todosLosDesperfectos() {
		return desperfectoRepository.findAll();
	}

//	Le pasamos el sector del inspector y se fija cuales tipos de desperfectos tiene
	public List<Desperfecto> desperfectoPorSector(String sector) {
		// Traemos todos los desperfectos
		List<Desperfecto> todosDesperfectos = desperfectoRepository.findAll();
		// Aca guardamos los desperfectos que su rubro sea igual al sector
		List<Desperfecto> desperfectoSector = new ArrayList<Desperfecto>();
		for (Desperfecto desperfecto : todosDesperfectos) {
			if (desperfecto.getRubro().getDescripcion().equals(sector)) {
				desperfectoSector.add(desperfecto);
			}
		}
		return desperfectoSector;
	}

	public Desperfecto buscarDesperfectoId(Integer idDesperfecto) {
		Optional<Desperfecto> desperfectoOptional = desperfectoRepository.findById(idDesperfecto);
		if (desperfectoOptional.isPresent()) {
			Desperfecto desperfecto = desperfectoOptional.get();
			return desperfecto;
		} else {
			return null;
		}
	}

	public List<Desperfecto> desperfectosInspector(Integer legajo) {
		List<Desperfecto> desperfectosInspector = new ArrayList<>();
		Personal inspector = personalService.perfilInspector(legajo);
		List<Desperfecto> desperfectos = todosLosDesperfectos();
		for (Desperfecto desperfecto : desperfectos) {
			String sectorInspector = inspector.getSector();
			String sectorDesperfecto = desperfecto.getRubro().getDescripcion();
			if (sectorInspector.equals(sectorDesperfecto)) {
				desperfectosInspector.add(desperfecto);
			}
		}
		return desperfectosInspector;

	}
}
