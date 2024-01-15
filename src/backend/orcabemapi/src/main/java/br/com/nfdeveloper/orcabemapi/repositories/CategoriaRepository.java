package br.com.nfdeveloper.orcabemapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nfdeveloper.orcabemapi.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
