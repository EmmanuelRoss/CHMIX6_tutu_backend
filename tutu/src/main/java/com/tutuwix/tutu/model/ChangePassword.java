package com.tutuwix.tutu.model;

public class ChangePassword {
	private String nombre_usu;
	private String contrasenia;
	private String newPassword;
	
	public ChangePassword() {
	}

	public ChangePassword(String nombre_usu, String contrasenia, String newPassword) {
		super();
		this.nombre_usu = nombre_usu;
		this.contrasenia = contrasenia;
		this.newPassword = newPassword;
	}

	public String getNombre_usu() {
		return nombre_usu;
	}

	public void setNombre_usu(String nombre_usu) {
		this.nombre_usu = nombre_usu;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ChangePassword [nombre_usu=" + nombre_usu + ", contrasenia=" + contrasenia + ", newPassword="
				+ newPassword + "]";
	}

	
	
	
}
