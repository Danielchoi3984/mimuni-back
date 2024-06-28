package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Desperfecto;
import com.example.demo.repository.DesperfectoRepository;

@Service
public class DesperfectoService {

	@Autowired
	DesperfectoRepository desperfectoRepository;

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

}
