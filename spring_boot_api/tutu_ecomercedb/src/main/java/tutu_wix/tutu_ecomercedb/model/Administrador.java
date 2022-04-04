package tutu_wix.tutu_ecomercedb.model;

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
	@Column(name="idaministrador", unique=true, nullable=false)
	private Long id;
	private String nombre_admin;
	private String contrasenia;
	
	public Administrador(Long id, String nombre_admin, String contrasenia) {
		this.id = id;
		this.nombre_admin = nombre_admin;
		this.contrasenia = contrasenia;
	}//constructor 
	
	public Administrador() {}//constructor vacio

	public String getNombre_admin() {
		return nombre_admin;
	}//getNombre_admin

	public void setNombre_admin(String nombre_admin) {
		this.nombre_admin = nombre_admin;
	}//setNombre_admin

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
		return "Administrador [id=" + id + ", nombre_admin=" + nombre_admin + ", contrasenia=" + contrasenia + "]";
	}//toString 

}//class administrador
