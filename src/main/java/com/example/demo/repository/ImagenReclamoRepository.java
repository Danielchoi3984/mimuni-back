package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.ImagenReclamo;
import java.util.List;

@Repository
public interface ImagenReclamoRepository extends JpaRepository<ImagenReclamo, Integer> {

	List<ImagenReclamo> findByIdReclamo(Integer idReclamo);

}
