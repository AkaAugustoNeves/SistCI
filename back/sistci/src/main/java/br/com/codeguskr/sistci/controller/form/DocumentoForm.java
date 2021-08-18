package br.com.codeguskr.sistci.controller.form;

import java.time.LocalDate;

import br.com.codeguskr.sistci.controller.dto.UsuarioDto;
import br.com.codeguskr.sistci.model.TipoDocumento;

public class DocumentoForm {
	
	private String destino;
	private String assunto;
	private String conteudo;
	private Long idCoordenacao;
	private Long idUsuario;
	private Long idTipoDocumento;
	
	public DocumentoForm() {
		// TODO Auto-generated constructor stub
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
	
	public Long getIdCoordenacao() {
		return idCoordenacao;
	}

	public void setIdCoordenacao(Long idCoordenacao) {
		this.idCoordenacao = idCoordenacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	
	

}
