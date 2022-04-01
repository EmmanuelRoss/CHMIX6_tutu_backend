package com.tutu.ecommerce_tutu.productos;
public class Producto {
	
	private String nombre;
	private String descripcion;
	private String url_imagen;
	private String talla;
	private Double precio;
	private Integer cantidad;
	private int id;
	private static int total=0;
	
	public Producto(String nombre, String descripcion, String url_imagen, String talla, double precio, int cantidad){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url_imagen = url_imagen;
		this.talla = talla;
		this.precio = precio;
		this.cantidad = cantidad;
		total++;
		this.id = total;
	}//constructor

	public Producto(){
		total++;
		this.id = total; 
	}//constructor

	
	public String getNombre() {
		return nombre;
	}//getNombre
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre
	
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

	public Double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(Double precio) {
		this.precio = precio;
	}//setPrecio

	public Integer getCantidad() {
		return cantidad;
	}//getCantidad

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}//setCantidad

	public int getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", url_imagen=" + url_imagen + ", talla="
				+ talla + ", precio=" + precio + ", cantidad=" + cantidad + ", id=" + id + "]";
	}//toString

}//class
