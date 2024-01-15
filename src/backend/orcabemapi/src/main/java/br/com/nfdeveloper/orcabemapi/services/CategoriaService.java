package br.com.nfdeveloper.orcabemapi.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nfdeveloper.orcabemapi.entities.Categoria;
import br.com.nfdeveloper.orcabemapi.entities.dtos.CategoriaDTO;
import br.com.nfdeveloper.orcabemapi.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria insert(CategoriaDTO obj) {
		Categoria newObj = new Categoria(null, obj.getTitulo(), obj.getDescricao(), new Date());
		return repo.save(newObj);
	}
	
	public List<Categoria> list(){
		return repo.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
