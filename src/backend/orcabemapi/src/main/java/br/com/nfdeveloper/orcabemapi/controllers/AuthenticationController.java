package br.com.nfdeveloper.orcabemapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nfdeveloper.orcabemapi.entities.User;
import br.com.nfdeveloper.orcabemapi.entities.dtos.AuthenticationDTO;
import br.com.nfdeveloper.orcabemapi.entities.dtos.LoginResponseDTO;
import br.com.nfdeveloper.orcabemapi.entities.dtos.RegisterDTO;
import br.com.nfdeveloper.orcabemapi.infra.security.TokenService;
import br.com.nfdeveloper.orcabemapi.repositories.UserRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
	
		var user = userRepository.findByLoginD(data.login());
		
		var token = tokenService.generateToken((User) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(user.getId(), token, user.getUsername()));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody RegisterDTO data) {
		if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User user = new User(null, data.nome(), data.sobrenome(), data.login(), encryptedPassword, data.salario(), data.role());

		this.userRepository.save(user);
		
		return ResponseEntity.ok().build();
	}
}





