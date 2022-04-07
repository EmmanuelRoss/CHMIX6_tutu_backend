package com.tutuwix.tutu.controller;

import com.tutuwix.tutu.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutuwix.tutu.service.CategoriasService;

@RestController
@RequestMapping(path="api/categoria")
public class CategoriaController {
	
	private final CategoriasService cateService;
	@Autowired
	public CategoriaController(CategoriasService cateService) {
		this.cateService = cateService; 
	}
	
	@GetMapping
	public List<Categoria> getCategoria(){
		return cateService.getCategorias();
	}
	
	@GetMapping(path="{cateId}")//Obtener todos los registros de una db
	public Categoria getCategoria(@PathVariable("cateId") Long idcategoria) {
		return cateService.getCategoria(idcategoria);
	}
	
	@DeleteMapping("{cateId}")//Eliminar un registro por un id
	public Categoria deleteCategoria(@PathVariable("cateId") Long idcategoria) {
		//return cateService.deleteCategoria(id);
		Categoria tmpCategoria =cateService.deleteCategoria(idcategoria);
		return tmpCategoria;
	}
	
	@PostMapping//Agregar una nueva categoria solo si esta no existe
	public Categoria addCategoria(@RequestBody Categoria categoria) {
		return cateService.addCategoria(categoria);		
	}
	
	@PutMapping(path="{cateId}")
	public Categoria updateCategoria(@PathVariable("cateId")Long idcategoria, @RequestParam(required=false) String nombre) {
		return cateService.updateCategoria(idcategoria, nombre);
	}
	
}
