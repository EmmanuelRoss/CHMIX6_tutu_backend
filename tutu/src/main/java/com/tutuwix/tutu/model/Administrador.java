package com.tutuwix.tutu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idadministrador", unique=true, nullable=false)
	private Long idadminisrador;
	private String nombre_admin;
	private String contrasenia;
	
	public Administrador(Long idadminisrador, String nombre_admin, String contrasenia) {
		this.idadminisrador = idadminisrador;
		this.nombre_admin = nombre_admin;
		this.contrasenia = contrasenia;
	}

	public Administrador() { }

	public Long getIdadminisrador() {
		return idadminisrador;
	}

	public void setIdadminisrador(Long idadminisrador) {
		this.idadminisrador = idadminisrador;
	}

	public String getNombre_admin() {
		return nombre_admin;
	}

	public void setNombre_admin(String nombre_admin) {
		this.nombre_admin = nombre_admin;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Administrador [idadminisrador=" + idadminisrador + ", nombre_admin=" + nombre_admin + ", contrasenia="
				+ contrasenia + "]";
	}
	
	
	
	
}
