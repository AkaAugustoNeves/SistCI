package br.com.codeguskr.sistci.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.codeguskr.sistci.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class TokenService {

	@Value("${codegu.jwt.expiration}")
	private String expiration;
	@Value("${codegu.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		System.out.println("ts: "+ expiration);
		System.out.println("ts: "+ secret);
		Usuario logado = (Usuario) authentication.getPrincipal();
		System.out.println("ts: "+ logado.getEmail());
		Date hoje = new Date();
		System.out.println("ts: hj "+ hoje);
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		System.out.println("ts: dtexp"+ dataExpiracao);
		
		return Jwts.builder()
				.setIssuer("token Jwt")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}
	
	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			System.out.println("ta valido ai o");
			return true;
		}catch (Exception e) {
			System.out.println("ta valido ai não");
			return false;
		}
	}	
	
	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
	
}
