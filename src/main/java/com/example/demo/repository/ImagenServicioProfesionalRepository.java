package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.ImagenServicioProfesional;
import java.util.List;

@Repository
public interface ImagenServicioProfesionalRepository extends JpaRepository<ImagenServicioProfesional, Integer> {

	List<ImagenServicioProfesional> findByIdservicioprofesional(Integer idservicioprofesional);
}
