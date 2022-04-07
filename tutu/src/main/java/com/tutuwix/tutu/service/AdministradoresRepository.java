package com.tutuwix.tutu.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutuwix.tutu.model.Administrador;


public interface AdministradoresRepository extends JpaRepository<Administrador, Long>{
	@Query("SELECT a FROM Administrador a WHERE a.nombre_admin=?1")
	Optional<Administrador>findByUsername(String nombre_admin);
}

