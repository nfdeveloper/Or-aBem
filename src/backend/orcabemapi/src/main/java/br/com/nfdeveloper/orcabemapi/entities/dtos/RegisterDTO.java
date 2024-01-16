package br.com.nfdeveloper.orcabemapi.entities.dtos;

import br.com.nfdeveloper.orcabemapi.entities.enums.UserRole;

public record RegisterDTO( String nome, String sobrenome, String login, String password,Double salario, UserRole role) {

}
