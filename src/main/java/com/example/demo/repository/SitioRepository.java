package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Sitio;

@Repository
public interface SitioRepository extends JpaRepository<Sitio, Integer> {

}
