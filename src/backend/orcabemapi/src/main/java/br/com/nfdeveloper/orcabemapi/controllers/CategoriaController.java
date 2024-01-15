package br.com.nfdeveloper.orcabemapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nfdeveloper.orcabemapi.entities.Categoria;
import br.com.nfdeveloper.orcabemapi.entities.dtos.CategoriaDTO;
import br.com.nfdeveloper.orcabemapi.services.CategoriaService;

@RestController
@RequestMapping("/categories")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list = service.list();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody CategoriaDTO obj){
		Categoria newObj = service.insert(obj);
		return ResponseEntity.ok().body(newObj);
	}
}
