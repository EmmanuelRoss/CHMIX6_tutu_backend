package com.tutuwix.tutu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutuwix.tutu.model.Categoria;

@Service
public class CategoriasService {
	public final ArrayList<Categoria>lista = new ArrayList<Categoria>();
		
	private final CategoriasRepository categoriasRepository;
	
	@Autowired
	public CategoriasService(CategoriasRepository categoriasRepository) {
		this.categoriasRepository = categoriasRepository;
	}
	
	public List<Categoria> getCategorias(){
		return categoriasRepository.findAll();//Regresa una lista de categorias de categoriasRepository
	}
	
	public Categoria getCategoria(Long id) {
		return categoriasRepository.findById(id).orElseThrow(
				() -> new IllegalStateException("La categoría con el id "+ id+"no existe."));
	}

	public Categoria deleteCategoria(Long id) {
		Categoria tmpCatego = null;
		if(categoriasRepository.existsById(id)) {
			tmpCatego = categoriasRepository.getById(id);
			categoriasRepository.deleteById(id);
		}
		return tmpCatego;
	}

	public Categoria addCategoria(Categoria categoria) {
		Categoria tmpCatego =  null;
		Optional<Categoria> cateByName= categoriasRepository.findByNombre(categoria.getNombre());
		if(cateByName.isPresent()) {
			throw new IllegalStateException("La categoria con el nombre [" + categoria.getNombre() +
					"] ya existe.");
		}else {
			categoriasRepository.save(categoria);
			tmpCatego = categoria;
		}
		return tmpCatego;
	}

	public Categoria updateCategoria(Long idcategoria, String nombre) {
		Categoria tmpCatego = null;
		for(Categoria categoria: lista) {
			if(categoria.getIdcategoria()==idcategoria) {
				if(nombre!=null)categoria.setNombre(nombre);
				tmpCatego=categoria;
				break;
			}
		}
		return tmpCatego;
	}
	
	
}
