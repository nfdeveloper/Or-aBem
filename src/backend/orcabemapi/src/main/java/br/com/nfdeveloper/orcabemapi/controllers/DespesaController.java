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

import br.com.nfdeveloper.orcabemapi.entities.Despesa;
import br.com.nfdeveloper.orcabemapi.entities.dtos.DespesaDTO;
import br.com.nfdeveloper.orcabemapi.services.DespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

	@Autowired
	private DespesaService service;
	
	@GetMapping
	public ResponseEntity<List<Despesa>> findAll(){
		List<Despesa> list = service.list();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Despesa> findById(@PathVariable Long id){
		Despesa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Despesa> create(@RequestBody DespesaDTO obj){
		Despesa newObj = service.insert(obj);
		return ResponseEntity.ok().body(newObj);
	}
}
