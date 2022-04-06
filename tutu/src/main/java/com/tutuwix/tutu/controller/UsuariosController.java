package com.tutuwix.tutu.controller;

import java.util.List;

import com.tutuwix.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutuwix.tutu.model.ChangePassword;
import com.tutuwix.tutu.model.Usuario;
import com.tutuwix.tutu.service.UsuariosService;

@RestController
@RequestMapping(path="api/usuarios")
public class UsuariosController {
	
	private final UsuariosService usuarioService;
	
	@Autowired
	public UsuariosController(UsuariosService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	@GetMapping(path= "{userId}")
	public Usuario getUsuario(@PathVariable("userId") Long id) {
		return usuarioService.getUsuario(id);
	}
	
	@DeleteMapping(path= "{userId}")
	public void deleteUsuario(@PathVariable("userId") Long idusuario) {
		usuarioService.deleteUsuario(idusuario);
	}
	
	@PostMapping
	public void addUsuario(@RequestBody Usuario usuario) {
		usuarioService.addUsuario(usuario);
	}
	
	 @PutMapping(path="{userId}")
	 public void updateUsuario(@RequestBody ChangePassword changePassword) {
		 usuarioService.updateUsuario(changePassword);
	 }
}
