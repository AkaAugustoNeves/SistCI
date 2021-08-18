package br.com.codeguskr.sistci.controller.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codeguskr.sistci.model.Documento;
import br.com.codeguskr.sistci.model.TipoDocumento;
import br.com.codeguskr.sistci.model.Usuario;

public class DocumentoDto {

	private Long id;
	private LocalDate data;
	private String destino;
	private String assunto;
	private String conteudo;
	private UsuarioDto usuario;
	private String tipoDocumento;
	private List<AnexoDto> anexos = new ArrayList<AnexoDto>();
	
	public DocumentoDto(Documento documento) {
		this.id = documento.getId();
		this.data = documento.getDate();
		this.destino = documento.getDestino();
		this.assunto = documento.getAssunto();
		this.conteudo = documento.getConteudo();
		this.usuario = new UsuarioDto(documento.getUsuario());
		this.tipoDocumento = documento.getTipoDocumento().getNome();
		this.anexos = AnexoDto.converter(documento.getAnexos());
	}
	
	public static List<DocumentoDto> converter(List<Documento> documentos){
		return documentos.stream().map(DocumentoDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<AnexoDto> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<AnexoDto> anexos) {
		this.anexos = anexos;
	}

	
	
	
}
