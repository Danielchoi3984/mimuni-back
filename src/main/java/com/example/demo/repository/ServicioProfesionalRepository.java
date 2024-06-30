package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.ServicioProfesional;
import com.example.demo.modelo.Vecinoregistrado;

public interface ServicioProfesionalRepository extends JpaRepository<ServicioProfesional, Integer> {

	public List<ServicioProfesional> findByEstado(String estado);

	
}
