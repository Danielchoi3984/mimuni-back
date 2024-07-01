package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.ImagenDenuncia;
import java.util.List;

@Repository
public interface ImagenDenunciaRepository extends JpaRepository<ImagenDenuncia, Integer> {

	List<ImagenDenuncia> findByIdDenuncia(Integer idDenuncia);

}
