package com.tutuwix.tutu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutuwix.tutu.model.Detalle_pedido;
import com.tutuwix.tutu.service.Detalle_pedidoService;


@RestController
@RequestMapping(path="/api/Detalle_pedido/")
public class Detalle_pedidoController {
	
	private final Detalle_pedidoService detService;
	@Autowired
	public Detalle_pedidoController(Detalle_pedidoService detService) {
		this.detService = detService;
	}//constructor
	
	@GetMapping
	public List<Detalle_pedido> getDetalle_pedidos(){
		return detService.getDetalle_pedidos();
	}//

	@GetMapping(path="{detaId}")
	public Detalle_pedido getDetalle_pedido(@PathVariable("detaId") Long id) {
		return detService.getDetalle_pedido(id);
	}//getDetalle_pedido

	@DeleteMapping(path="{detaId}")
	public Detalle_pedido deleteDetalle_pedido(@PathVariable("detaId") Long id) {
		return detService.deleteDetalle_pedido(id);
	}//deleteDetalle_producto
	
	@PostMapping
	public Detalle_pedido addDetalle_pedido(@RequestBody Detalle_pedido detalle_pedido) {
		return detService.addDetalle_pedido(detalle_pedido);
	}//addDetalle_pedido
	
	@PutMapping(path="{detaId}")
	public Detalle_pedido updateDetalle_pedido(@PathVariable("detaId") Long id,
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) Integer cantidad,
			@RequestParam(required = false) Integer productos_idproductos,
			@RequestParam(required = false) Integer pedido_idpedido) {
		return detService.updateDetalle_pedido(id, precio, cantidad, productos_idproductos, pedido_idpedido);
	}//updateDetalle_pedido
	
}//class Detalle_pedido
