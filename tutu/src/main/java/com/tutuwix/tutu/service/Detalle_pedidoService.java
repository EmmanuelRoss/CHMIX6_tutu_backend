package com.tutuwix.tutu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutuwix.tutu.model.Detalle_pedido;


@Service
public class Detalle_pedidoService {
	
	private final Detalle_pedidoRepository detalle_pedidoRepository;
	@Autowired
	public Detalle_pedidoService(Detalle_pedidoRepository detalle_pedidoRepository) {
		this.detalle_pedidoRepository = detalle_pedidoRepository;
	}//constructor

	public List<Detalle_pedido> getDetalle_pedidos() {
		return detalle_pedidoRepository.findAll();
	}//getDetalle_pedido

	public Detalle_pedido getDetalle_pedido(Long id) {
		return detalle_pedidoRepository.findById(id).orElseThrow(
				()-> new IllegalStateException("El detalle del pedido don este id " + id + "no existe"));
	}//getdetalle_pedido

	public Detalle_pedido deleteDetalle_pedido(Long id) {
		Detalle_pedido tmpDetalle =null;
		if(detalle_pedidoRepository.existsById(id)) {
			tmpDetalle = detalle_pedidoRepository.findById(id).get();
			detalle_pedidoRepository.deleteById(id);
		}//exist
		return tmpDetalle;
	}//deletedetalle_producto

	public Detalle_pedido addDetalle_pedido(Detalle_pedido detalle_pedido) {
		Detalle_pedido tmpDetalle =null;
		Optional<Detalle_pedido> detaById=detalle_pedidoRepository.findById(detalle_pedido.getId()); 
		if(detaById.isPresent()) {
			throw new IllegalStateException("ese numero de Id " + detalle_pedido.getId() + " ya existe.");
		}else {
			detalle_pedidoRepository.save(detalle_pedido);
			tmpDetalle = detalle_pedido;
		}//else
		return tmpDetalle; 
	}//addProducto
	
	public Detalle_pedido updateDetalle_pedido(Long id, Double precio, Integer cantidad, Integer productos_idproductos,
			Integer pedido_idpedido) {
		Detalle_pedido tmpDetalle =null;
		if(detalle_pedidoRepository.existsById(id)) {
			tmpDetalle = detalle_pedidoRepository.findById(id).get();
			if (precio!=null && precio.doubleValue()>0)tmpDetalle.setPrecio(precio.doubleValue());
			if (cantidad!=null && cantidad.intValue()>0)tmpDetalle.setCantidad(cantidad.intValue());
			if (productos_idproductos!=null && productos_idproductos.intValue()>0)tmpDetalle.setProductos_idproductos(productos_idproductos.intValue());
			if (pedido_idpedido!=null && pedido_idpedido.intValue()>0)tmpDetalle.setPedido_idpedido(pedido_idpedido.intValue());
			detalle_pedidoRepository.save(tmpDetalle);
		}else {
			System.out.println("no existe el detalle de pedido con el id " +id);
		}//else //if
		
		return tmpDetalle;
	}//updatedetalle_pedido

}//class ProductoService
