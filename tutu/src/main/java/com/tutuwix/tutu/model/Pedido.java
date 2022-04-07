package com.tutuwix.tutu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpedido", unique=true, nullable = false)
	private Long id;
	private String fecha_pedido;
	private String direccion; 
	private String municipio;
	private String telefono;
	private String ciudad;
	private int unidades;
	private int codigopostal;
	private int usuario_idusuario;
	
	public Pedido(Long id, String fecha_pedido, String direccion, String municipio, String telefono, String ciudad,
			int unidades, int codigopostal, int usuario_idusuario) {
		this.id = id;
		this.fecha_pedido = fecha_pedido;
		this.direccion = direccion;
		this.municipio = municipio;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.unidades = unidades;
		this.codigopostal = codigopostal;
		this.usuario_idusuario = usuario_idusuario;
	}//constructor
	
	public Pedido() {}//contructor vacio

	public String getFecha_pedido() {
		return fecha_pedido;
	}//getFecha_pedido

	public void setFecha_pedido(String fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}//setFecha_pedido

	public String getDireccion() {
		return direccion;
	}//getDireccion

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}//setDireccion

	public String getMunicipio() {
		return municipio;
	}//getMunicipio

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}//setMunicipio

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono

	public String getCiudad() {
		return ciudad;
	}//getCiudad

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}//setCiudad

	public int getUnidades() {
		return unidades;
	}//getUnidades

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}//SetUnidades

	public int getCodigopostal() {
		return codigopostal;
	}//getCodigoposta

	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}//setCodigopostal

	public int getUsuario_idusuario() {
		return usuario_idusuario;
	}//getUsuario_idusuario

	public void setUsuario_idusuario(int usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}//setUsuario_idusuario

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha_pedido=" + fecha_pedido + ", direccion=" + direccion + ", municipio="
				+ municipio + ", telefono=" + telefono + ", ciudad=" + ciudad + ", unidades=" + unidades
				+ ", codigopostal=" + codigopostal + ", usuario_idusuario=" + usuario_idusuario + "]";
	}//toString
 	
}//class Pedido