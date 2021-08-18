package br.com.codeguskr.sistci.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codeguskr.sistci.model.TipoDocumento;
import br.com.codeguskr.sistci.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tdr;
	
	public List<TipoDocumento> buscarTodos(){
		return tdr.findAll();
	}
	
	public TipoDocumento porId(Long id) {
		Optional<TipoDocumento> tipodoc = tdr.findById(id);
		if(tipodoc.isPresent()) {
			return tipodoc.get();
		}
		return null;
	}
	
}
