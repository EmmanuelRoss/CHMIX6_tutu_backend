package tutu_wix.tutu_ecomercedb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tutu_wix.tutu_ecomercedb.model.Categoria;

@Service
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}//constructor
	
	public List<Categoria> getCategorias() {
		return categoriaRepository.findAll();
	}//getProductos

	public Categoria getCategoria(Long id) {
		return categoriaRepository.findById(id).orElseThrow(
				()-> new IllegalStateException("la categoria con el id " + id + "no exixte"));
	}//getProducto

	public Categoria deleteCategoria(Long id) {
		Categoria tmpCategoria = null;
		if(categoriaRepository.existsById(id)) {
			tmpCategoria =categoriaRepository.findById(id).get();
			categoriaRepository.deleteById(id);
		}//exist
		return tmpCategoria;
	}//deleteCategoria

	public Categoria addCategoria(Categoria categoria) {
		Categoria tmpCategoria = null;
		Optional<Categoria> catByName=categoriaRepository.findByNombre(categoria.getNombre());
		if(catByName.isPresent()) {
			throw new IllegalStateException("La categoria con el nombre " + categoria.getNombre() + "ya existe");
		}else {
			categoriaRepository.save(categoria);
			tmpCategoria = categoria;
		}
		return tmpCategoria;
	}//addCategoria

	public Categoria updateCategoria(Long id, String nombre) {
		Categoria tmpCategoria = null;
		if(categoriaRepository.existsById(id)) {
			tmpCategoria = categoriaRepository.findById(id).get();
			if (nombre!=null)tmpCategoria.setNombre(nombre);
			categoriaRepository.save(tmpCategoria);
		}else {
			System.out.println("no existe la categoria con el id " + id);
		}//else //if
		return tmpCategoria;
	}//updatecategoria

}//class CategoriaService
