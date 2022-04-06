package com.tutuwix.tutu.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutuwix.tutu.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{
	@Query("SELECT u FROM Usuario u WHERE u.nombre_usu=?1")
	Optional<Usuario> findByUsername (String nombre_usu);	
}
