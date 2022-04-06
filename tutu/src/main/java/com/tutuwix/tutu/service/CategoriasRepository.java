package com.tutuwix.tutu.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutuwix.tutu.model.Categoria;

///Ponemos las reglas que queremos que cumplan otras clases
public interface CategoriasRepository extends JpaRepository<Categoria, Long>{//Reutiliza codigo
	@Query("SELECT c FROM Categoria c WHERE c.nombre=?1")//Lenguage jpql para traer en un elemento llamado c desde la tabla llamada categoria y deonde c corresponda a c.nombre elemento 1(=?1)
	Optional<Categoria>findByNombre(String nombre);//Para definir que no se pueden ingresar más de una categoria con el mismo nombre
}
