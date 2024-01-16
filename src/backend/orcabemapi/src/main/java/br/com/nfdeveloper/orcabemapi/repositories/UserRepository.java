package br.com.nfdeveloper.orcabemapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.nfdeveloper.orcabemapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	UserDetails findByLogin(String login);
	
	@Query("SELECT obj FROM User obj WHERE obj.login = :user")
	User findByLoginD(@Param("user") String login);
}
