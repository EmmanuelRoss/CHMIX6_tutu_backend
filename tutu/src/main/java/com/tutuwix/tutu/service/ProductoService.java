package com.tutuwix.tutu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutuwix.tutu.model.Producto;


@Service
public class ProductoService {

	private final ProductosRepository productosRepository;

	@Autowired
	public ProductoService(ProductosRepository productosRepository) {
		this.productosRepository = productosRepository;
	}//constructor

	public List<Producto> getProductos(){
		return productosRepository.findAll();
	}//getProductos
	
	public Producto getProducto(Long id) {
		return productosRepository.findById(id).orElseThrow(
				()-> new IllegalStateException("El producto con el id " + id + "no existe."));
	}//getProducto

	public Producto deleteProducto(Long id) {
		Producto tmpProducto = null;
		if(productosRepository.existsById(id)) {
			tmpProducto = productosRepository.findById(id).get();
			productosRepository.deleteById(id);
		}//exist
		return tmpProducto;
	}//deleteProducto

	public Producto addProducto(Producto producto) {
		Producto tmpProducto =null;
		Optional<Producto> prodByName=productosRepository.findByNombre(producto.getNombre_prod()); 
		if(prodByName.isPresent()) {
			throw new IllegalStateException("El producto con el nombre " + producto.getNombre_prod() + " ya existe.");
		}else {
			productosRepository.save(producto);
			tmpProducto = producto;
		}//else
		return tmpProducto; 
	}//addProducto

	public Producto updateProducto(Long id, String nombre_prod, String descripcion, String url_imagen, String talla,
			Double precio, Integer cantidad_dis, Integer categoria_idcategoria) {
		Producto tmpProducto =null;
		if(productosRepository.existsById(id)) {
			tmpProducto = productosRepository.findById(id).get();
		if (nombre_prod!=null) tmpProducto.setNombre_prod(nombre_prod);
		if (descripcion!=null) tmpProducto.setDescripcion(descripcion);
		if (url_imagen!=null) tmpProducto.setUrl_imagen(url_imagen);
		if (talla!=null) tmpProducto.setTalla(talla);
		if (precio!=null && precio.doubleValue()>0) tmpProducto.setPrecio(precio.doubleValue());
		if (cantidad_dis!=null && cantidad_dis.intValue()>0) tmpProducto.setCantidad_dis(cantidad_dis.intValue());
		if (categoria_idcategoria!=null && categoria_idcategoria.intValue()>0) tmpProducto.setCategoria_idcategoria(categoria_idcategoria.intValue());
		productosRepository.save(tmpProducto);
		}else {
			System.out.println("no existe el producto con el id " + id);
		}//else //if 
		
		return tmpProducto;
	}//updateProduct
		
}//class ProductoService