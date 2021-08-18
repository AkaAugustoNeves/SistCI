package br.com.codeguskr.sistci.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.codeguskr.sistci.model.Usuario;
import br.com.codeguskr.sistci.repository.UsuarioRepository;
import br.com.codeguskr.sistci.service.TokenService;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	
	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;
	
	public AutenticacaoViaTokenFilter(TokenService ts, UsuarioRepository ur) {
		this.tokenService = ts;
		this.usuarioRepository = ur;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValid(token);
		if (valido) {
			autenticarCliente(token);
		}
		filterChain.doFilter(request, response);
		
	}
	
	private void autenticarCliente(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		System.out.println("id: "+idUsuario);
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		System.out.println("email : "+usuario.getEmail());
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token==null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		System.out.println(token);
		return token.substring(7, token.length());
	}
	
}
