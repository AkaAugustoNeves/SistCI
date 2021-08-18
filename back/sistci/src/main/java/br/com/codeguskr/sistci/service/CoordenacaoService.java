package br.com.codeguskr.sistci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codeguskr.sistci.model.Coordenacao;
import br.com.codeguskr.sistci.repository.CoordenacaoRepository;

@Service
public class CoordenacaoService {

	@Autowired
	private CoordenacaoRepository cr;
	
	public List<Coordenacao> buscarTodos() {
		return cr.findAll();
	}
	
	public Coordenacao porId(Long id) {
		return cr.findById(id).get();
	}
}
