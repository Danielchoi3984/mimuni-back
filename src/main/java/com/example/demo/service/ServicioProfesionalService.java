package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.ServicioProfesional;
import com.example.demo.repository.ServicioProfesionalRepository;

@Service
public class ServicioProfesionalService {

	@Autowired
	ServicioProfesionalRepository repositorioProfesional;

	public List<ServicioProfesional> serviciosProfesionalesHabilitados() {
		// Servicios todos tiene habilitados y bloqueados
//		List<ServicioProfesional> serviciosTodos =  repositorioProfesional.findAll();
		List<ServicioProfesional> serviciosHabilitados = repositorioProfesional.findByEstado("H");
		return serviciosHabilitados;
	}

}