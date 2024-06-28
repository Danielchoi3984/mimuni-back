package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Personal;
import com.example.demo.repository.PersonalRepository;

@Service
public class PersonalService {

	@Autowired
	PersonalRepository repositorio;

	// NUEVOOOOOOOOO: Despues entrega (DEVUELVE AL INSPECTOR)
	public Personal perfilInspector(Integer legajo) {
		Optional<Personal> inspectorOptional = repositorio.findById(legajo);
		if (inspectorOptional.isPresent()) {
//			Encontramos al inspector
			Personal inspector = inspectorOptional.get();
			return inspector;
		} else {
			return null;
		}
	}

	public boolean loginInspector(Integer legajo, String password) {
		Optional<Personal> optionalPersonal = repositorio.findById(legajo);
		if (optionalPersonal.isEmpty()) {
			System.out.println("NO ESTAS REGISTRADO COMO INSPECTOR");
			return false;
		} else if (optionalPersonal.get().getPassword().equals(password)) {
			Personal personalMunicipal = optionalPersonal.get();
			if (personalMunicipal.getCategoria() == 8) {
				System.out.println("LOGIN INSPECTOR EXITOSO");
				return true;
			} else {
				System.out.println("SOS EMPLEADO MUNICIPAL PERO NO INSPECTOR");
				return false;
			}
		} else {
			System.out.println("LOGIN INSPECTOR FALLIDO: CONTRASENIA INCORRECTA");
			return false;
		}
	}

	public boolean cambiarPassword(Integer legajo, String passwordActual, String passwordNueva, String passwordNueva2) {
		Optional<Personal> optionalPersonal = repositorio.findById(legajo);
		if (optionalPersonal.isPresent()) {
			Personal personal = optionalPersonal.get();
			if (personal.getPassword().equals(passwordActual) && passwordNueva.equals(passwordNueva2)) {
				personal.setPassword(passwordNueva);
				repositorio.save(personal);
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	public List<Personal> inspectores() {
		return repositorio.findAll();
	}

}
