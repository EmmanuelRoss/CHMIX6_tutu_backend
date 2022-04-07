package com.tutuwix.tutu.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import com.tutuwix.tutu.jwt.config.JwtFilter;
import com.tutuwix.tutu.model.Token;
import com.tutuwix.tutu.model.Usuario;
import com.tutuwix.tutu.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
@CrossOrigin("*")
public class LoginController {
	private final UsuariosService usuariosService;
	@Autowired
	public LoginController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	/*
	@PostMapping
	public String login(@RequestBody Usuario usuario) {
		return usuariosService.validateUsuario(usuario);
	}*/
	
	@PostMapping
	public Token login(@RequestBody Usuario usuario) throws ServletException {
		//if(usuariosService.validateUsuario(usuario)) {
		if(usuariosService.validateUsuario(usuario)) {
			//return new Token(usuario.getUsername());
			return new Token(generateToken(usuario.getNombre_usu()));
			
		}
		
		throw new ServletException("Nombre de usuario o contraseña incorrectos");
	}
	
	
	private String generateToken(String username) { 
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.HOUR, 10); 
		return Jwts.builder().setSubject(username).claim("role", "user") 
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact(); 
	}// generateToken 
}
