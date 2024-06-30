package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Reclamo;
import java.util.List;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {

	List<Reclamo> findByLegajo(Integer legajo);


}
