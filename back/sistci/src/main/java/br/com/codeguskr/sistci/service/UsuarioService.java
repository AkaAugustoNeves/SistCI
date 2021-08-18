package br.com.codeguskr.sistci.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.codeguskr.sistci.controller.dto.UsuarioDto;
import br.com.codeguskr.sistci.controller.form.UsuarioForm;
import br.com.codeguskr.sistci.model.Coordenacao;
import br.com.codeguskr.sistci.model.Usuario;
import br.com.codeguskr.sistci.repository.CoordenacaoRepository;
import br.com.codeguskr.sistci.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private CoordenacaoService cs;
	
	public ResponseEntity<UsuarioDto> buscarUsuarioId(Long id) {
		Optional<Usuario> usuario = ur.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok().body(new UsuarioDto(usuario.get()));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<UsuarioDto> criarUsuario(UsuarioForm form) {
		Coordenacao coordenacao = cs.porId(form.getIdCoordenacao());
		Usuario usuario = ur.save(new Usuario(form, coordenacao));
		return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioDto(usuario));
	}
	
	public ResponseEntity<UsuarioDto> editarUsuario(UsuarioForm form, Long id){
		Optional<Usuario> usuario = ur.findById(id);
		if (usuario.isPresent()) {
			Coordenacao coordenacao = cs.porId(form.getIdCoordenacao());
			usuario.get().setCoordenacao(coordenacao);
			usuario.get().setEmail(form.getEmail());
			usuario.get().setNome(form.getNome());
			usuario.get().setSenha(form.getSenha());
			return ResponseEntity.status(HttpStatus.OK).body(new UsuarioDto(ur.save(usuario.get())));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
	}
	
	public ResponseEntity<UsuarioDto> excluirUsuario(Long id){
		Optional<Usuario> usuario = ur.findById(id);
		if (usuario.isPresent()) {
			ur.deleteById(id);
			return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	public Usuario porId(Long id) {
		Optional<Usuario> usuario = ur.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
			
		}
		return null;
		
	}
	
	
}
