package br.com.codeguskr.sistci.controller.dto;

import br.com.codeguskr.sistci.model.Usuario;

public class UsuarioDto {
	
	private Long Id;
	private String nome;
	private String email;
	private String coordenacaoNome;
	private Long coordenacaoId;
	
	public UsuarioDto(Usuario usuario) {
		this.Id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.coordenacaoNome = usuario.getCoordenacao().getNome();
		this.coordenacaoId = usuario.getCoordenacao().getId(); 
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCoordenacaoNome() {
		return coordenacaoNome;
	}

	public void setCoordenacaoNome(String coordenacaoNome) {
		this.coordenacaoNome = coordenacaoNome;
	}

	public Long getCoordenacaoId() {
		return coordenacaoId;
	}

	public void setCoordenacaoId(Long coordenacaoId) {
		this.coordenacaoId = coordenacaoId;
	}
	
	

}
