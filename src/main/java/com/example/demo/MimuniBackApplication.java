package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.BarrioService;
import com.example.demo.service.PersonalService;
import com.example.demo.service.ServicioComercioService;
import com.example.demo.service.ServicioProfesionalService;
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

	public static void main(String[] args) {
		SpringApplication.run(MimuniBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Aca Hagamos las pruebas amigos
		
	}

}
