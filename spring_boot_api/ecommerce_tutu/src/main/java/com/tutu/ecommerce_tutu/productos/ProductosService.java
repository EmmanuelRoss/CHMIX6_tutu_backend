package com.tutu.ecommerce_tutu.productos;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {	
	public final ArrayList<Producto> lista =new ArrayList<Producto>();
	
	public ProductosService() {
		lista.add(new Producto("sombrero rojo","sombrero tipo wirrarrika","sombreroRojo.jpg", "chico", 300.0, 20));
		lista.add(new Producto("sombrero azul","sombrero ojo de dios","sombreroRojo.jpg", "mediano", 400.0, 100));
		lista.add(new Producto("sombrero gris","sombrero celeste del cielo","sombreroRojo.jpg", "grande", 500.0, 250));
	}//constructor

	public ArrayList<Producto> getProductos() {
		return lista;
	}//getProductos

	public Producto getProducto(Long prodId) {
		Producto tmpProd = null;
		for (Producto producto : lista) {
			if(producto.getId()==prodId){
				tmpProd = producto;
				break;
			}//if==prodId
		}//foreach
		return tmpProd;
	}//getProducto

	public Producto deleteProducto(Long prodId) {
		Producto tmpProd = null;
		for (Producto producto : lista) {
			if(producto.getId()==prodId){
				tmpProd =lista.remove(lista.indexOf(producto));
				break;
			}//if==prodId
		}//foreach
		return tmpProd;
	}//deleteProducto

	public Producto addProducto(Producto producto) {
		lista.add(producto);
		return producto;
	}//addProducto

	public Producto updateProducto(Long prodId, String nombre, String descripcion, String url_imagen, String talla, Double precio, Integer cantidad) {
		Producto tmpProd = null;
		for (Producto producto : lista) {
			if(producto.getId()==prodId){
				if(nombre!=null) producto.setNombre(nombre);
				if(descripcion!=null) producto.setDescripcion(descripcion);
				if(url_imagen!=null) producto.setUrl_imagen(url_imagen);
				if(talla!=null) producto.setTalla(talla);
				if(precio!=null && precio>0) producto.setPrecio(precio);
				if(cantidad!=null && cantidad>0) producto.setCantidad(cantidad);
				tmpProd = producto;
				break;
			}//if==prodId 
		}//foreach
		return tmpProd;
	}//updateProducto
	
	
}//class ProductosService
