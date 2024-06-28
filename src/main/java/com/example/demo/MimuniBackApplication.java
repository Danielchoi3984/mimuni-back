package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Sitio;
import com.example.demo.service.BarrioService;
import com.example.demo.service.PersonalService;
import com.example.demo.service.ServicioComercioService;
import com.example.demo.service.ServicioProfesionalService;
import com.example.demo.service.SitioService;
import com.example.demo.service.VecinoService;

@SpringBootApplication
public class MimuniBackApplication implements CommandLineRunner {

	@Autowired
	BarrioService barrioService;

	@Autowired
	PersonalService personalService;

	@Autowired
	VecinoService vecinoService;

	@Autowired
	ServicioComercioService comercioService;

	@Autowired
	ServicioProfesionalService profesionalService;

	@Autowired
	SitioService sitioService;

	public static void main(String[] args) {
		SpringApplication.run(MimuniBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Aca Hagamos las pruebas amigossdsss
		
		List<Sitio> sitios = sitioService.sitios();
		mostrarSitios(sitios);

	}

	public void mostrarSitios(List<Sitio> sitios) {
		System.out.println("----------- SITIOS ---------");
		for (Sitio sitio : sitios) {
			System.out.println(sitio);
		}
	}

}
