package com.tutu.ecommerce_tutu.usuarios;

import java.util.ArrayList;

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
@RestController
@RequestMapping(path="/api/usuarios/")
@CrossOrigin(origins="http://localhost:5500")
public class UsuariosController {
	private final UsuariosService usuariosService;
	@Autowired
	public UsuariosController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}//constructor
	
	@GetMapping
	public ArrayList<Usuario> getUsuarios(){
		return usuariosService.getUsuarios();
	}//getUsuarios
	
	@GetMapping(path="{usuId}")
	public Usuario getUsuario(@PathVariable("usuId") Long usuId) {
		return usuariosService.getUsuario(usuId);
	}//getUsuario

	@DeleteMapping(path="{usuId}")
	public Usuario deleteUsuario(@PathVariable("usuId") Long usuId) {
		return usuariosService.deleteUsuario(usuId);
	}//deleteUsuario
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuariosService.addUsuario(usuario);
	}//addUsuario
	
	@PutMapping(path="{usuId}")
	public Usuario updateUsuario(@PathVariable("usuId") Long usuId,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String apellido,
			@RequestParam(required=false) String correo,
			@RequestParam(required=false) String contrasenia) {
		
		return usuariosService.updateUsuario(usuId, nombre, apellido, correo, contrasenia);
	}//updateUsuario
		
}//class UsuariosController
