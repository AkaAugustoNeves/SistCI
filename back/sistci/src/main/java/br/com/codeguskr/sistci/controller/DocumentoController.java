package br.com.codeguskr.sistci.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.codeguskr.sistci.controller.dto.DocumentoDto;
import br.com.codeguskr.sistci.controller.dto.ListaDocumentosDto;
import br.com.codeguskr.sistci.controller.form.DocumentoForm;
import br.com.codeguskr.sistci.model.Documento;
import br.com.codeguskr.sistci.service.DocumentoService;

@RestController
@RequestMapping("/documentos")
@CrossOrigin(origins = "http://localhost:4201")
public class DocumentoController {

	@Autowired
	private DocumentoService ds;
	
	@GetMapping()
	public ResponseEntity<List<DocumentoDto>> list(){
		return ds.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DocumentoDto> listPorPessoa(@PathVariable Long id){
		return ds.BuscarPorId(id);
	}
	
	@PostMapping
	public ResponseEntity<DocumentoDto> criarDocumento(@RequestBody DocumentoForm form){
		return ds.criarDocumento(form);
	}
	
	@GetMapping("/custom")
	public List<DocumentoDto> teste(@RequestParam String dataInicio, @RequestParam String dataFinal ) {
		System.out.println(dataInicio);
		System.out.println(dataFinal);
		return ds.teste(dataInicio, dataFinal);
	}
	
	@GetMapping("/coordenacao")
	public ListaDocumentosDto porCoord(@RequestParam Long idCoord ) {
		return ds.porCoord(idCoord);
	}
}
