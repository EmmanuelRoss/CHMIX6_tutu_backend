package com.tutuwix.tutu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutuwix.tutu.model.Pedido;
import com.tutuwix.tutu.service.PedidoService;


@RestController
@RequestMapping(path="/api/pedido/")
@CrossOrigin("*")
public class PedidoController {
	
	private final PedidoService pediService;
	@Autowired
	public PedidoController(PedidoService pediService) {
		this.pediService = pediService;
	}//constructor
	
	@GetMapping
	public List<Pedido> getPedidos() {
		return pediService.getPedidos();
	}//getPedido
	
	@GetMapping(path="{pedId}")
	public Pedido getPedido(@PathVariable("pedId") Long id) {
		return pediService.getPedido(id);
	}//getpedido 
	
	@DeleteMapping(path="{pedId}")
	public Pedido detelePedido(@PathVariable("pedId") Long id) {
		return pediService.deletePedido(id);
	}//deletepedido
	
	@PostMapping
	public Pedido addPedido(@RequestBody Pedido pedido) {
		return pediService.addPedido(pedido);
	}//addPedido
	
	@PutMapping(path="{pedId}")
	public Pedido updatePedido(@PathVariable("pedId") Long id,
			@RequestParam(required = false) String fecha_pedido,
			@RequestParam(required = false) String direccion,
			@RequestParam(required = false) String municipio,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String ciudad,
			@RequestParam(required = false) Integer unidades,
			@RequestParam(required = false) Integer codigopostal,
			@RequestParam(required = false) Integer usuario_idusuario) {
		return pediService.updatePedido(id, fecha_pedido, direccion, municipio, telefono, ciudad, unidades, codigopostal, usuario_idusuario);
	}//updatePedido

}//class PedidoController
