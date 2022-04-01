package com.tutu.ecommerce_tutu.usuarios;
public class Usuario {
	
	
	private String nombre;
	private String apellido;
	private String correo;
	private String contraseni;
	private int id_usuario;
	private static int total=0;
	
	public Usuario(String nombre, String apellido, String correo, String contraseni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseni = contraseni;
		total++;
		this.id_usuario = total;
	}//constructor
	
	public Usuario() {
		total++;
		this.id_usuario = total;
	}//constructor

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getApellido() {
		return apellido;
	}//getApellido

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}//setApellido

	public String getCorreo() {
		return correo;
	}//getCorreo

	public void setCorreo(String correo) {
		this.correo = correo;
	}//setCorreo

	public String getContraseni() {
		return contraseni;
	}//getContrasenia

	public void setContraseni(String contraseni) {
		this.contraseni = contraseni;
	}//setContrasenia

	public int getId_usuario() {
		return id_usuario;
	}//getId_usuario

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contraseni="
				+ contraseni + ", id_usuario=" + id_usuario + "]";
	}//toString
	
}//class
