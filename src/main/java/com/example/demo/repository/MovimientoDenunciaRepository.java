package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.MovimientoDenuncia;

@Repository
public interface MovimientoDenunciaRepository extends JpaRepository<MovimientoDenuncia, Integer> {

}
