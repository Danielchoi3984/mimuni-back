package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Rubro;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, Integer> {

}
