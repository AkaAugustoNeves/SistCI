package br.com.codeguskr.sistci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codeguskr.sistci.controller.dto.TokenDto;
import br.com.codeguskr.sistci.controller.form.LoginForm;
import br.com.codeguskr.sistci.service.TokenService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4201")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody LoginForm form){
		System.out.println(form.getEmail());
		System.out.println(form.getSenha());
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			System.out.println(token);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		}catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.badRequest().build();
		}
	}
	
}
