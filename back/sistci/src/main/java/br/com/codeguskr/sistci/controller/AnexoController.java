package br.com.codeguskr.sistci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.codeguskr.sistci.controller.dto.AnexoDto;
import br.com.codeguskr.sistci.service.AnexoService;

@RestController
@RequestMapping("/anexos")
@CrossOrigin(origins = "http://localhost:4201")
public class AnexoController {

	@Autowired
	private AnexoService as;
	
	@PostMapping("/{idDocumento}/{idUsuario}/{assinado}")
	public ResponseEntity<List<AnexoDto>> criarAnexos(@RequestBody MultipartFile[] files, @PathVariable Long idDocumento, @PathVariable Long idUsuario, @PathVariable Boolean assinado){
		return as.criarAnexos(files, idDocumento, idUsuario, assinado);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ByteArrayResource> listPorId(@PathVariable Long id){
		return as.download(id);
	}
	
}
