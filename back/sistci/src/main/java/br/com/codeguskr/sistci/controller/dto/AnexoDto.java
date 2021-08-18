package br.com.codeguskr.sistci.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.codeguskr.sistci.model.Anexo;

public class AnexoDto {

	private Long id;
	private String nome;
	private String tipo;
	private String usuarioNome;
	private boolean assinado;
	
	public AnexoDto(Anexo anexo) {
		this.id = anexo.getId();
		this.nome = anexo.getNome();
		this.tipo = anexo.getTipo();
		this.usuarioNome = anexo.getUsuario().getNome();
		this.assinado = anexo.getAssinado();
	}

	public static List<AnexoDto> converter(List<Anexo> anexos){
		return anexos.stream().map(AnexoDto::new).collect(Collectors.toList());
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

	public boolean isAssinado() {
		return assinado;
	}

	public void setAssinado(boolean assinado) {
		this.assinado = assinado;
	}
	
	
}

