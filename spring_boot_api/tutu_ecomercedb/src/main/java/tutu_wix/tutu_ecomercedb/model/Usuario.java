package tutu_wix.tutu_ecomercedb.model;

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
	@Column(name="idusuario", unique=true, nullable = false)
	private Long id; 
	private String nombre_usu;
	private String apellido;
	private String correo;
	private String contrasenia;
	
	public Usuario(Long id, String nombre_usu, String apellido, String correo, String contrasenia) {
		this.id = id;
		this.nombre_usu = nombre_usu;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
	}//constructor
	
	public Usuario() {}//contructor vacio

	public String getNombre_usu() {
		return nombre_usu;
	}//getNombre_usu

	public void setNombre_usu(String nombre_usu) {
		this.nombre_usu = nombre_usu;
	}//setNombre_usu

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

	public String getContrasenia() {
		return contrasenia;
	}//getContrasenia

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}//setContrasenia

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre_usu=" + nombre_usu + ", apellido=" + apellido + ", correo=" + correo
				+ ", contrasenia=" + contrasenia + "]";
	}//toString
	
}//class Usuario