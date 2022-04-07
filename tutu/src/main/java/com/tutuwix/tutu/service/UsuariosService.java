package com.tutuwix.tutu.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutuwix.tutu.model.ChangePassword;
import com.tutuwix.tutu.model.Usuario;
import com.tutuwix.tutu.utils.SHAUtils;


@Service
public class UsuariosService {
	
	private final UsuariosRepository usuariosRepository;
	
	@Autowired
	public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}
	
	public List<Usuario> getUsuarios(){
		return usuariosRepository.findAll();
	}
	
	public Usuario getUsuario(Long id) {
		return usuariosRepository.findById(id).orElseThrow(
				()-> new IllegalStateException(
						"El usuario con el id "+id+"no existe."));
	}
	
	public void deleteUsuario(Long id) {
		if(usuariosRepository.existsById(id)) {
			usuariosRepository.deleteById(id);
		}
	}
	
	public void addUsuario(Usuario usuario) {
		Optional<Usuario> userByName=usuariosRepository.findByUsername(usuario.getNombre_usu());
		if(userByName.isPresent()) {
			throw new IllegalStateException("El usuario con el nombre [" + usuario.getNombre_usu() +
			"] Ya existe.");
		}else {
			usuario.setContrasenia(SHAUtils.createHash(usuario.getContrasenia()));//Va a cifrar la contraseña del usuario cuando ingresamos un usuario nuevo a la DB
			usuariosRepository.save(usuario);
		}
	}

	public void updateUsuario(ChangePassword changePassword) {		
		Optional<Usuario> userByName=usuariosRepository.findByUsername(changePassword.getNombre_usu());
		if(userByName.isPresent()) {
			Usuario u = userByName.get();
//			if(u.getPassword().equals(changePassword.getPassword())) {
//			u.setPassword(changePassword.getNewPassword());
			if(SHAUtils.verifyHash(changePassword.getContrasenia(), u.getContrasenia())) {								
				u.setContrasenia(SHAUtils.createHash(changePassword.getNewPassword()));
				usuariosRepository.save(u);
			}
		}
	}

	public boolean validateUsuario(Usuario usuario) {
		//res="Nombre de usuario o contraseña incorrectos";
		boolean res=false;
		Optional<Usuario> userByName=usuariosRepository.findByUsername(usuario.getNombre_usu());
		if(userByName.isPresent()) {
			Usuario u = userByName.get();
//			if(u.getContrasenia().equals(usuario.getContrasenia())) {
			if(SHAUtils.verifyHash(usuario.getContrasenia(), u.getContrasenia())) {
				//res="OK";
				res=true;
			}
		}
		//return res;
		return res;
	}
}