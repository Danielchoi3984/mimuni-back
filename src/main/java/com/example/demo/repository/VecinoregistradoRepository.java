package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Vecinoregistrado;

public interface VecinoregistradoRepository extends JpaRepository<Vecinoregistrado, String> {
	public List<Vecinoregistrado> findByMail(String mail);

}
