package br.com.codeguskr.sistci.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.codeguskr.sistci.controller.dto.DocumentoDto;
import br.com.codeguskr.sistci.controller.dto.ListaDocumentosDto;
import br.com.codeguskr.sistci.controller.form.DocumentoForm;
import br.com.codeguskr.sistci.model.Coordenacao;
import br.com.codeguskr.sistci.model.Documento;
import br.com.codeguskr.sistci.model.TipoDocumento;
import br.com.codeguskr.sistci.model.Usuario;
import br.com.codeguskr.sistci.repository.DocumentoRepository;

@Service
public class DocumentoService {

	@Autowired
	private DocumentoRepository dr;
	
	@Autowired
	private TipoDocumentoService tds;
	
	@Autowired
	private UsuarioService us;
	
	@Autowired
	private CoordenacaoService cs;
	
	public ResponseEntity<List<DocumentoDto>> listar(){
		List<Documento> documentos = dr.findAll();
		return ResponseEntity.ok().body(DocumentoDto.converter(documentos));
		
	}
	
	public ResponseEntity<DocumentoDto> BuscarPorId(Long id){
		Optional<Documento> documento = dr.findById(id);
		if (documento.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new DocumentoDto(documento.get()));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	public ResponseEntity<DocumentoDto> criarDocumento(DocumentoForm form){
		TipoDocumento tipoDocumento = tds.porId(form.getIdTipoDocumento());
		Usuario usuario = us.porId(form.getIdUsuario());
		Coordenacao coordenacao =  usuario.getCoordenacao();
		return ResponseEntity.status(HttpStatus.CREATED).body(new DocumentoDto(dr.save(new Documento(form, coordenacao, tipoDocumento, usuario))));
	}
	
	public Documento porId(Long id){
		return dr.findById(id).get();
	}

	public List<DocumentoDto> teste(String dataInicio, String dataFinal) {
		return DocumentoDto.converter(dr.buscarPorDatas(dataInicio, dataFinal));
	}
	
	public ListaDocumentosDto porCoord(Long coordenacaoId) {
		ListaDocumentosDto documentos = new ListaDocumentosDto();
		documentos.setCis(DocumentoDto.converter(dr.findByCoordenacaoAndTipoDoc(new Long(1) ,coordenacaoId)));
		documentos.setCirculars(DocumentoDto.converter(dr.findByCoordenacaoAndTipoDoc(new Long(2) ,coordenacaoId)));
		documentos.setOficios(DocumentoDto.converter(dr.findByCoordenacaoAndTipoDoc(new Long(3) ,coordenacaoId)));
		return documentos;
		
	}
	
}
