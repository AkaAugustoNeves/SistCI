package br.com.codeguskr.sistci.controller.form;

public class UsuarioForm {

	private String nome;
	private String email;
	private String senha;
	private Long idCoordenacao;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getIdCoordenacao() {
		return idCoordenacao;
	}
	public void setIdCoordenacao(Long idCoordenacao) {
		this.idCoordenacao = idCoordenacao;
	}
	
	
	
	
	
}
