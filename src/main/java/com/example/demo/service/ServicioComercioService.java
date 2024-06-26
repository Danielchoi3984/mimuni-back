package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.ServicioComercio;
import com.example.demo.repository.ServicioComercioRepository;

@Service
public class ServicioComercioService {
	@Autowired
	ServicioComercioRepository repositorio;

	public List<ServicioComercio> serviciosComerciosHabilitados() {
		List<ServicioComercio> comerciosHabilitados = repositorio.findByEstado("H");
		return comerciosHabilitados;
	}
}
