package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.DatosDenuncia;

@Repository
public interface DatosDenunciaRepository extends JpaRepository<DatosDenuncia, Integer> {

}
