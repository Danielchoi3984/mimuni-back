package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.MovimientoReclamo;
import java.util.List;

@Repository
public interface MovimientoReclamoRepository extends JpaRepository<MovimientoReclamo, Integer> {

	List<MovimientoReclamo> findByIdReclamo(Integer idReclamo);

}
