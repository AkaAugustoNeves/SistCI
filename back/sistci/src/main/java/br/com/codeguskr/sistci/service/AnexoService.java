package br.com.codeguskr.sistci.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import br.com.codeguskr.sistci.controller.dto.AnexoDto;
import br.com.codeguskr.sistci.model.Anexo;
import br.com.codeguskr.sistci.model.Documento;
import br.com.codeguskr.sistci.model.Usuario;
import br.com.codeguskr.sistci.repository.AnexoRepository;

@Service
public class AnexoService {
	
	@Autowired
	private DocumentoService ds;
	
	@Autowired
	private UsuarioService us;
	
	@Autowired
	private AnexoRepository ar;

	public ResponseEntity<List<AnexoDto>> criarAnexos(MultipartFile[] files, Long idDocumento, Long idUsuario, Boolean assinado) {
		Documento documento = ds.porId(idDocumento);
		Usuario usuario = us.porId(idUsuario);
		List<AnexoDto> anexos = new ArrayList<AnexoDto>();
		for(MultipartFile file : files) {
			anexos.add(this.save(file, documento, usuario, assinado));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(anexos);
		
	}

	public AnexoDto save(MultipartFile file, Documento documento, Usuario usuario, boolean assinado) {
		try {
			return new AnexoDto(ar.save(new Anexo(file.getOriginalFilename(), file.getContentType(), file.getBytes(), documento, usuario, assinado)));
		}catch (Exception e) {
			return null;
		}
	}

	public ResponseEntity<ByteArrayResource> download(Long id) {
		Anexo anexo = this.porId(id);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(anexo.getTipo()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= "+anexo.getNome())
				.body(new ByteArrayResource(anexo.getDados()));
	}
	
	public Anexo porId(Long id) {
		return ar.findById(id).get();
	}
}
