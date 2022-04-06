package com.tutuwix.tutu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario", unique=true, nullable=false)
	private Long idusuario;
	private String nombre_usu;
	private String apellido;
	private String correo;
	private String contrasenia;
	
	public Usuario(Long idusuario, String nombre_usu, String apellido, String correo, String contrasenia) {
		this.idusuario = idusuario;
		this.nombre_usu = nombre_usu;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
	}

	public Usuario() { }

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre_usu() {
		return nombre_usu;
	}

	public void setNombre_usu(String nombre_usu) {
		this.nombre_usu = nombre_usu;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre_usu=" + nombre_usu + ", apellido=" + apellido + ", correo="
				+ correo + ", contrasenia=" + contrasenia + "]";
	}
			
	
	
}
