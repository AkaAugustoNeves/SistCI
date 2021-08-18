package br.com.codeguskr.sistci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codeguskr.sistci.controller.dto.UsuarioDto;
import br.com.codeguskr.sistci.controller.form.UsuarioForm;
import br.com.codeguskr.sistci.model.Usuario;
import br.com.codeguskr.sistci.service.UsuarioService;

@RestController
@RequestMapping("/admin/usuarios")
@CrossOrigin(origins = "http://localhost:4201")
public class UsuarioController {

	@Autowired
	private UsuarioService us;
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> buscar(@PathVariable Long id) {
		return us.buscarUsuarioId(id);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> criar(@RequestBody UsuarioForm form) {
		return us.criarUsuario(form);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDto> editar(@RequestBody UsuarioForm form, @PathVariable Long id ){
		return us.editarUsuario(form, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioDto> excluir(@PathVariable Long id){
		return us.excluirUsuario(id);
	}
}
