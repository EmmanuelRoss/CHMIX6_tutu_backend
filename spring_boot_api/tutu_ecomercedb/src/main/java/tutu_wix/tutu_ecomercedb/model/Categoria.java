package tutu_wix.tutu_ecomercedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcategoria", unique=true, nullable = false)
	private Long id;
	private String nombre;
	
	public Categoria(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}//constructor
	
	public Categoria() {}//constructor vacio

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}//toString 
	
	
	
	
}//class Categoria
