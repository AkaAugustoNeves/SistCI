package br.com.codeguskr.sistci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codeguskr.sistci.model.TipoDocumento;
import br.com.codeguskr.sistci.service.TipoDocumentoService;

@RestController
@RequestMapping("/tipodocumento")
@CrossOrigin(origins = "http://localhost:4201")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoService tds;
	
	@GetMapping
	public List<TipoDocumento> listarTodos(){
		return tds.buscarTodos();
	}
	
}
