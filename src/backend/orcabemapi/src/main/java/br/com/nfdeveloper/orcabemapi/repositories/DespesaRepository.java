package br.com.nfdeveloper.orcabemapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nfdeveloper.orcabemapi.entities.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
