package com.tutuwix.tutu.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutuwix.tutu.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	@Query("SELECT p FROM Categoria p WHERE p.nombre=?1")
	Optional<Categoria> findByNombre (String nombre);
}//interface CategoriaRepository
