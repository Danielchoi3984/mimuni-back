package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Denuncia;
import com.example.demo.modelo.Desperfecto;
import com.example.demo.modelo.MovimientoReclamo;
import com.example.demo.modelo.Rubro;
import com.example.demo.modelo.Sitio;

import com.example.demo.repository.DenunciaRepository;
import com.example.demo.repository.DesperfectoRepository;
import com.example.demo.repository.MovimientoReclamoRepository;
import com.example.demo.repository.RubroRepository;
import com.example.demo.service.BarrioService;
import com.example.demo.service.DenunciaService;
import com.example.demo.service.DesperfectoService;
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

	@Autowired
	RubroRepository rubroRepository;

	@Autowired
	DesperfectoRepository desperfectoRepository;

	@Autowired
	DesperfectoService desperfectoService;

	@Autowired
	MovimientoReclamoRepository movimientoReclamoRepository;

	@Autowired
	DenunciaService denunciaService;

	public static void main(String[] args) {
		SpringApplication.run(MimuniBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Aca Hagamos las pruebas amigossdsss

//		List<Sitio> sitios = sitioService.sitios();
//		mostrarSitios(sitios);

//		List<Rubro> rubros = rubroRepository.findAll();
//		for (Rubro rubro : rubros) {
//			System.out.println(rubro);
//		}

//		List<Desperfecto> desperfectos = desperfectoService.desperfectosInspector(1);
//		for (Desperfecto desperfecto : desperfectos) {
//			System.out.println(desperfecto);
//		}


	}

}
