package com.tutuwix.tutu.service;

import java.util.List;
import java.util.Optional;

import com.tutuwix.tutu.service.AdministradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutuwix.tutu.model.ChangePasswordAdmin;
import com.tutuwix.tutu.model.Administrador;
import com.tutuwix.tutu.utils.SHAUtils;

@Service
public class AdministradoresService {
	public final AdministradoresRepository administradoresRepository;
	
	@Autowired
	public AdministradoresService(AdministradoresRepository administradoresRepository) {
		this.administradoresRepository= administradoresRepository;
	}
	
	public List<Administrador> getAdministradores(){
		return administradoresRepository.findAll();
	}
	
	public Administrador getAdministrador(Long id) {
		return administradoresRepository.findById(id).orElseThrow(
				()-> new IllegalStateException(
						"El administrador con el id "+id+"no existe."));
	}
	
	public void deleteAdministrador(Long id) {
		if(administradoresRepository.existsById(id)) {
			administradoresRepository.deleteById(id);
		}
	}
	
	public void addAdministrador(Administrador administrador) {
		Optional<Administrador> userByName=administradoresRepository.findByUsername(administrador.getNombre_admin());
		if(userByName.isPresent()) {
			throw new IllegalStateException("El administrador con el nombre [" + administrador.getNombre_admin() +
			"] Ya existe.");
		}else {
			administrador.setContrasenia(SHAUtils.createHash(administrador.getContrasenia()));//Va a cifrar la contraseña del administrador cuando ingresamos un administrador nuevo a la DB
			administradoresRepository.save(administrador);
		}
	}

	public void updateAdministrador(ChangePasswordAdmin changePasswordAdmin) {		
		Optional<Administrador> userByName=administradoresRepository.findByUsername(changePasswordAdmin.getNombre_admin());
		if(userByName.isPresent()) {
			Administrador a = userByName.get();
//			if(u.getPassword().equals(changePassword.getPassword())) {
//			u.setPassword(changePassword.getNewPassword());
			if(SHAUtils.verifyHash(changePasswordAdmin.getNewContrasenia(), a.getContrasenia())) {								
				a.setContrasenia(SHAUtils.createHash(changePasswordAdmin.getContrasenia()));
				administradoresRepository.save(a);
			}
		}
	}	
	

	public boolean validateAdministrador(Administrador administrador) {
		//res="Nombre de administrador o contraseña incorrectos";
		boolean res=false;
		Optional<Administrador> userByName=administradoresRepository.findByUsername(administrador.getNombre_admin());
		if(userByName.isPresent()) {
			Administrador u = userByName.get();
//			if(u.getPassword().equals(administrador.getPassword())) {
			if(SHAUtils.verifyHash(administrador.getContrasenia(), u.getContrasenia())) {
				//res="OK";
				res=true;
			}
		}
		//return res;
		return res;
	}
}
