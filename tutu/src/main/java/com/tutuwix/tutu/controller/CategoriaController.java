package com.tutuwix.tutu.controller;

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

import com.tutuwix.tutu.model.Categoria;
import com.tutuwix.tutu.service.CategoriaService;



@RestController
@RequestMapping(path="/api/categoria/")
public class CategoriaController {

	private final CategoriaService cateService;
	@Autowired
	public CategoriaController(CategoriaService cateService) {
		this.cateService = cateService; 
	}//constructor
	
	@GetMapping
	public List<Categoria> getCategorias(){
		return cateService.getCategorias(); 
	}//getCategoria
	
	@GetMapping(path="{cateId}")
	public Categoria getCategoria(@PathVariable("cateId")Long id ) {
		return cateService.getCategoria(id);
	}//getCategoria
	
	@DeleteMapping(path="{cateId}")
	public Categoria deleteCategoria(@PathVariable("cateId")Long id ) {
		return cateService.deleteCategoria(id);
	}//deleteCategoria
	
	@PostMapping
	public Categoria addCategoria(@RequestBody Categoria categoria) {
		return cateService.addCategoria(categoria);
	}//addCategoria
	
	@PutMapping(path="{cateId}")
	public Categoria updateCategoria(@PathVariable("cateId")Long id, 
			@RequestParam(required = false) String nombre ) {
		return cateService.updateCategoria(id, nombre);
	}//updateCategoria
	
	
}//class CategoriaController
