package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Vecino;

@Repository
public interface VecinoRepository extends JpaRepository<Vecino, String> {

}
