package br.com.nfdeveloper.orcabemapi.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nfdeveloper.orcabemapi.entities.Categoria;
import br.com.nfdeveloper.orcabemapi.entities.Despesa;
import br.com.nfdeveloper.orcabemapi.entities.dtos.DespesaDTO;
import br.com.nfdeveloper.orcabemapi.repositories.CategoriaRepository;
import br.com.nfdeveloper.orcabemapi.repositories.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repo;
	@Autowired
	private CategoriaRepository catRepo;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
	
	public Despesa insert(DespesaDTO obj) {
		Categoria categoria = catRepo.findById(obj.getCategoria_id()).get();
		Despesa newObj = new Despesa(null, obj.getDescricao(), obj.getValor(), obj.getData_cadastro(), obj.getData_pagamento(), obj.getVencimento(), obj.getPago(),categoria );
		return repo.save(newObj);
	}
	
	public List<Despesa> list(){
		return repo.findAll();
	}
	
	public Despesa findById(Long id) {
		Optional<Despesa> obj = repo.findById(id);
		return obj.orElseThrow();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
