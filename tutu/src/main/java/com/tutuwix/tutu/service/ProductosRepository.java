package com.tutuwix.tutu.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutuwix.tutu.model.Producto;


public interface ProductosRepository extends JpaRepository<Producto, Long> {
	@Query("SELECT p FROM Producto p WHERE p.nombre_prod=?1")
	Optional<Producto> findByNombre (String nombre_prod);
}//interface ProductosRepository

