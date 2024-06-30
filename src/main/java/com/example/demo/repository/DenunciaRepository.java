package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Denuncia;
import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {

	List<Denuncia> findByDocumento(String documento);

}
