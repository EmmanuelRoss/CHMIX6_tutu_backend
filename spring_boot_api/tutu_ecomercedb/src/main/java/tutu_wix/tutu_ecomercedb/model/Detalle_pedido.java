package tutu_wix.tutu_ecomercedb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle_pedido")
public class Detalle_pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iddetalle_pedido", unique=true, nullable = false)
	private Long id;
	private double precio;
	private int cantidad;
	private int productos_idproductos;
	private int pedido_idpedido;
	
	public Detalle_pedido(Long id, double precio, int cantidad, int productos_idproductos, int pedido_idpedido) {
		this.id = id;
		this.precio = precio;
		this.cantidad = cantidad;
		this.productos_idproductos = productos_idproductos;
		this.pedido_idpedido = pedido_idpedido;
	}//constructor
	
	public Detalle_pedido() {}//constructor vacio

	public double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(double precio) {
		this.precio = precio;
	}//setPrecio

	public int getCantidad() {
		return cantidad;
	}//getCantidad

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}//setCantidad

	public int getProductos_idproductos() {
		return productos_idproductos;
	}//getProductos_idproductos

	public void setProductos_idproductos(int productos_idproductos) {
		this.productos_idproductos = productos_idproductos;
	}//setProductos_idproductos

	public int getPedido_idpedido() {
		return pedido_idpedido;
	}//getPredido_idpedido

	public void setPedido_idpedido(int pedido_idpedido) {
		this.pedido_idpedido = pedido_idpedido;
	}//setPedido_idpedido

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Detalle_pedido [id=" + id + ", precio=" + precio + ", cantidad=" + cantidad + ", productos_idproductos="
				+ productos_idproductos + ", pedido_idpedido=" + pedido_idpedido + "]";
	}//toString

}//class Detalle_pedido
