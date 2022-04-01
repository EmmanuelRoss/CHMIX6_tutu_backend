package com.tutu.ecommerce_tutu.productos;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping (path="/api/productos/")
@CrossOrigin(origins="http://localhost:5500")//*
public class ProductosController {
	private final ProductosService productosService;
	@Autowired
	public ProductosController(ProductosService productosService) {
		this.productosService = productosService;
	}//constructor
	
	@GetMapping
	public ArrayList<Producto> getProductos() {
		return productosService.getProductos();
	}//getProductos	
	
	@GetMapping(path="{prodId}")
	public Producto getProducto(@PathVariable("prodId") Long prodId) {
		return productosService.getProducto(prodId);
	}//getProducto
	
	@DeleteMapping(path="{prodId}") 
	public Producto deletProducto(@PathVariable("prodId") Long prodId){
		 return productosService.deleteProducto(prodId);
	}//deleteProducto
	
	@PostMapping
	public Producto addProducto(@RequestBody Producto producto) {
		return productosService.addProducto(producto);
	}//addProducto
	 
	@PutMapping(path="{prodId}")
	public Producto updateProducto(@PathVariable("prodId") Long prodId,	
			@RequestParam(required=false) String nombre, 
			@RequestParam(required=false) String descripcion, 
			@RequestParam(required=false) String url_imagen,
			@RequestParam(required=false) String talla,
			@RequestParam(required=false) Double precio, 
			@RequestParam(required=false) Integer cantidad) {
		return productosService.updateProducto(prodId, nombre, descripcion, url_imagen, talla, precio, cantidad);
	}//updateProducto
	
}//class ProductosController









