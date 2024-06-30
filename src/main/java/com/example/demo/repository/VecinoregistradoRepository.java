package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Vecinoregistrado;

@Repository
public interface VecinoregistradoRepository extends JpaRepository<Vecinoregistrado, String> {
	public List<Vecinoregistrado> findByMail(String mail);

}
