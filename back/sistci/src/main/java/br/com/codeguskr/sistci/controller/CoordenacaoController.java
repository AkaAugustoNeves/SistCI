package br.com.codeguskr.sistci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codeguskr.sistci.model.Coordenacao;
import br.com.codeguskr.sistci.service.CoordenacaoService;

@RestController
@RequestMapping("/coordenacao")
@CrossOrigin(origins = "http://localhost:4201")
public class CoordenacaoController {

	@Autowired
	private CoordenacaoService cs;
	
	@GetMapping
	private List<Coordenacao> buscarTodos() {
		return cs.buscarTodos();
	}
	
}
