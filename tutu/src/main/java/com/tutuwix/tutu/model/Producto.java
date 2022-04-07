package com.tutuwix.tutu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproductos", unique=true, nullable=false)
	private Long id;
	private String nombre_prod;
	private String descripcion;
	private String url_imagen;
	private String talla;
	private double precio;
	private int cantidad_dis; 
	private int categoria_idcategoria;
	
	
	
	public Producto(Long id, String nombre_prod, String descripcion, String url_imagen, String talla, double precio,
			int cantidad_dis, int categoria_idcategoria) {
		this.id = id;
		this.nombre_prod = nombre_prod;
		this.descripcion = descripcion;
		this.url_imagen = url_imagen;
		this.talla = talla;
		this.precio = precio;
		this.cantidad_dis = cantidad_dis;
		this.categoria_idcategoria = categoria_idcategoria;
	}//constructor

	public Producto(){}//contructor vacio 

	public String getNombre_prod() {
		return nombre_prod;
	}//getNombre_prod

	public void setNombre_prod(String nombre_prod) {
		this.nombre_prod = nombre_prod;
	}//setNombre_prod

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion 

	public String getUrl_imagen() {
		return url_imagen;
	}//getUrl_imagen

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}//setUrl_imagen 

	public String getTalla() {
		return talla;
	}//getTalla

	public void setTalla(String talla) {
		this.talla = talla;
	}//setTalla

	public double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(double precio) {
		this.precio = precio;
	}//setPrecio

	public int getCantidad_dis() {
		return cantidad_dis;
	}//getCantidad_dis

	public void setCantidad_dis(int cantidad_dis) {
		this.cantidad_dis = cantidad_dis;
	}//setCantidad_dis

	public Long getId() {
		return id;
	}//getIdProductos
	
	public int getCategoria_idcategoria() {
		return categoria_idcategoria;
	}//getCategoria_idcategoria

	public void setCategoria_idcategoria(int categoria_idcategoria) {
		this.categoria_idcategoria = categoria_idcategoria;
	}//setCategoria_idcategoria

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre_prod=" + nombre_prod + ", descripcion=" + descripcion + ", url_imagen="
				+ url_imagen + ", talla=" + talla + ", precio=" + precio + ", cantidad_dis=" + cantidad_dis
				+ ", categoria_idcategoria=" + categoria_idcategoria + "]";
	}//toString

	
	
}//class producto
