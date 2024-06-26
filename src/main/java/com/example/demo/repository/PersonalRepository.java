package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer> {

}
