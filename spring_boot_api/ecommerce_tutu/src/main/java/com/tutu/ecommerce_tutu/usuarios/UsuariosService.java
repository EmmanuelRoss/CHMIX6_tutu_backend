package com.tutu.ecommerce_tutu.usuarios;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
	public final ArrayList<Usuario> lista =new ArrayList<Usuario>();
	
	public UsuariosService() {
		lista.add(new Usuario("gustavo", "Martinez", "gustavo@gmail.com", "tavo"));
		lista.add(new Usuario("emmanuel", "rosales", "emmanuel@gmail.com", "emma"));
		lista.add(new Usuario("ponchito", "castañeda", "ponchito@gmail.com", "poncho"));
	}//constructor
	
	public ArrayList<Usuario> getUsuarios(){
		return lista;
	}//getUsuarios
	
	public Usuario getUsuario(Long usuId) {
		Usuario tmpUsu = null;
		for(Usuario usuario : lista) {
			if(usuario.getId_usuario()==usuId) {
				tmpUsu = usuario;
				break;
			}//if==usuId
		}//foreach
		return tmpUsu;
	}///getUsuario
	
	public Usuario deleteUsuario(Long usuId) {
		Usuario tmpUsu = null;
		for(Usuario usuario : lista) {
			if(usuario.getId_usuario()==usuId) {
				tmpUsu = lista.remove(lista.indexOf(usuario));
				break;
			}//if==usuId
		}//foreach
		return tmpUsu;
	}///deleteUsuario
	
	public Usuario addUsuario(Usuario usuario) {
		lista.add(usuario);
		return usuario;
	}//addProducto
	
	public Usuario updateUsuario(Long usuId, String nombre, String apellido, String correo, String contrasenia) {
		Usuario tmpUsu =null;
		for(Usuario usuario : lista) {
			if(usuario.getId_usuario()==usuId) {
				if(nombre!=null) usuario.setNombre(nombre);
				if(apellido!=null) usuario.setApellido(apellido);
				if(correo!=null) usuario.setCorreo(correo);
				if(contrasenia!=null) usuario.setContraseni(contrasenia);
				tmpUsu =usuario;
				break;
			}//if==usuId
		}//foreach
		return tmpUsu;
	}//udateUsuario

}//class UsuariosService




