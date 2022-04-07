package com.tutuwix.tutu.model;

public class ChangePasswordAdmin {
	private String nombre_admin;
	private String contrasenia;
	private String newContrasenia;
	
	public ChangePasswordAdmin() {
	}

	public ChangePasswordAdmin(String nombre_admin, String contrasenia, String newContrasenia) {
		super();
		this.nombre_admin = nombre_admin;
		this.contrasenia = contrasenia;
		this.newContrasenia = newContrasenia;
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

	public String getNewContrasenia() {
		return newContrasenia;
	}

	public void setNewContrasenia(String newContrasenia) {
		this.newContrasenia = newContrasenia;
	}

	@Override
	public String toString() {
		return "ChangePasswordAdmin [nombre_admin=" + nombre_admin + ", contrasenia=" + contrasenia
				+ ", newContrasenia=" + newContrasenia + "]";
	}
	
	

}
