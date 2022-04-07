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

import com.tutuwix.tutu.model.Producto;
import com.tutuwix.tutu.service.ProductoService;



@RestController
@RequestMapping(path="/api/productos/")
public class ProductosController {

	private final ProductoService prodService;
	@Autowired
	public ProductosController(ProductoService prodService) {
		this.prodService = prodService;
	}//constructor
	
	@GetMapping
	public List<Producto> getProductos() {
		return prodService.getProductos();
	}//getProducto
	
	@GetMapping(path="{prodId}")
	public Producto getProducto(@PathVariable("prodId") Long id) {
		return prodService.getProducto(id);
	}//getProducto 
	
	@DeleteMapping(path="{prodId}")
	public Producto deteleProducto(@PathVariable("prodId") Long id) {
		return prodService.deleteProducto(id);
	}//deleteProducto
	
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		return prodService.addProducto(producto);
	}//addProducto
	
	@PutMapping(path="{prodId}")
	public Producto updateProducto(@PathVariable("prodId") Long id,
			@RequestParam(required = false) String nombre_prod,
			@RequestParam(required = false) String descripcion,
			@RequestParam(required = false) String url_imagen,
			@RequestParam(required = false) String talla,
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) Integer cantidad_dis,
			@RequestParam(required = false) Integer categoria_idcategoria) {
		return prodService.updateProducto(id, nombre_prod, descripcion, url_imagen, talla, precio, cantidad_dis, categoria_idcategoria);
	}//updateProducto
	
}//class ProductosController