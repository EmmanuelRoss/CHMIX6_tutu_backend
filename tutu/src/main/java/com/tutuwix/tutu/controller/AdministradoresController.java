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
import org.springframework.web.bind.annotation.RestController;

import com.tutuwix.tutu.model.Administrador;
import com.tutuwix.tutu.model.ChangePasswordAdmin;
import com.tutuwix.tutu.service.AdministradoresService;

@RestController
@RequestMapping(path="/api/administradores/")
public class AdministradoresController {
	
	private final AdministradoresService administradorService;
	
	@Autowired
	public AdministradoresController(AdministradoresService administradorService) {
		this.administradorService = administradorService;
	}
	
	@GetMapping
	public List<Administrador> getAdministradores(){
		return administradorService.getAdministradores();
	}
	
	@GetMapping(path= "{userId}")
	public Administrador getAdministrador(@PathVariable("userId") Long id) {
		return administradorService.getAdministrador(id);
	}
	
	@DeleteMapping(path= "{userId}")
	public void deleteAdministrador(@PathVariable("userId") Long idadministrador) {
		administradorService.deleteAdministrador(idadministrador);
	}
	
	@PostMapping
	public void addAdministrador(@RequestBody Administrador administrador) {
		administradorService.addAdministrador(administrador);
	}
	
	 @PutMapping(path="{userId}")
	 public void updateAdministrador(@RequestBody ChangePasswordAdmin changePasswordAdmin) {
		 administradorService.updateAdministrador(changePasswordAdmin);
	 }
}