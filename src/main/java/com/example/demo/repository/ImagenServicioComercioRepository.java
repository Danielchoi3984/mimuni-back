package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.ImagenServicioComercio;
import java.util.List;

@Repository
public interface ImagenServicioComercioRepository extends JpaRepository<ImagenServicioComercio, Integer> {

	List<ImagenServicioComercio> findByIdserviciocomercio(Integer idserviciocomercio);

}
