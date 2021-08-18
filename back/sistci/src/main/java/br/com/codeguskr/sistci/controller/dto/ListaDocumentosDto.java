package br.com.codeguskr.sistci.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class ListaDocumentosDto {

	private List<DocumentoDto> cis = new ArrayList<>();
	private List<DocumentoDto> circulars = new ArrayList<>();
	private List<DocumentoDto> oficios = new ArrayList<>();
	
	public ListaDocumentosDto() {
		// TODO Auto-generated constructor stub
	}

	public List<DocumentoDto> getCirculars() {
		return circulars;
	}

	public void setCirculars(List<DocumentoDto> circulars) {
		this.circulars = circulars;
	}

	public List<DocumentoDto> getCis() {
		return cis;
	}

	public void setCis(List<DocumentoDto> cis) {
		this.cis = cis;
	}

	public List<DocumentoDto> getOficios() {
		return oficios;
	}

	public void setOficios(List<DocumentoDto> oficios) {
		this.oficios = oficios;
	}
	
	
}
