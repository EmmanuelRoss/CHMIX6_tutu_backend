package tutu_wix.tutu_ecomercedb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tutu_wix.tutu_ecomercedb.model.Pedido;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}//constructor
	
	public List<Pedido> getPedidos() {
		return pedidoRepository.findAll();
	}//getPedido

	public Pedido getPedido(Long id) {
		return pedidoRepository.findById(id).orElseThrow(
				()-> new IllegalStateException("el pedido con el id " + id + "no existe."));
	}//getPedido

	public Pedido deletePedido(Long id) {
		Pedido tmpPedido = null;
		if(pedidoRepository.existsById(id)) {
			tmpPedido = pedidoRepository.findById(id).get();
			pedidoRepository.deleteById(id);
		}//exist
		return tmpPedido;
	}//deletePedido

	public Pedido addPedido(Pedido pedido) {
		Pedido tmpPedido = null;
		Optional<Pedido> pediById=pedidoRepository.findById(pedido.getId());
		if(pediById.isPresent()) {
			throw new IllegalStateException("El pedido con el Id " + pedido.getId() + "ya existe");
		}else {
			pedidoRepository.save(pedido);
			tmpPedido = pedido;
		}//else
		return tmpPedido;
	}//addPedido

	public Pedido updatePedido(Long id, String fecha_pedido, String direccion, String municipio, String telefono,
			String ciudad, Integer unidades, Integer codigopostal, Integer usuario_idusuario) {
		Pedido tmpPedido = null;
		if(pedidoRepository.existsById(id)) {
			tmpPedido = pedidoRepository.findById(id).get();
			if(fecha_pedido!=null) tmpPedido.setFecha_pedido(fecha_pedido);
			if(direccion!=null) tmpPedido.setDireccion(direccion);
			if(municipio!=null) tmpPedido.setMunicipio(municipio);
			if(telefono!=null) tmpPedido.setTelefono(telefono);
			if(ciudad!=null) tmpPedido.setCiudad(ciudad);
			if(unidades!=null && unidades.intValue()>0) tmpPedido.setUnidades(unidades.intValue());
			if(codigopostal!=null && codigopostal.intValue()>0) tmpPedido.setCodigopostal(codigopostal.intValue());
			if(usuario_idusuario!=null && usuario_idusuario.intValue()>0) tmpPedido.setUsuario_idusuario(usuario_idusuario.intValue());
			pedidoRepository.save(tmpPedido);
		}else {
			System.out.println("no existe el pedido con el id " + id);
		}//else //if 
		return tmpPedido;
	}//updatePedido
}//class PedidoService