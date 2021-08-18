package br.com.codeguskr.sistci.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Anexo {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
	private String nome;
	private String tipo;
	private LocalDate date = LocalDate.now();
	private Boolean assinado;
	private LocalDate dateDelete;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Documento documento;
	@Lob
    private byte[] dados;
	
	public Anexo(String nome, String tipo, byte[] dados, Documento documento, Usuario usuario, boolean assinado) {
		this.nome = nome;
		this.tipo = tipo;
		this.dados = dados;
		this.documento = documento;
		this.usuario = usuario;
		this.assinado = assinado;
	}
	
	public Anexo() {
		// TODO Auto-generated constructor stub
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getAssinado() {
		return assinado;
	}

	public void setAssinado(Boolean assinado) {
		this.assinado = assinado;
	}

	public LocalDate getDateDelete() {
		return dateDelete;
	}

	public void setDateDelete(LocalDate dateDelete) {
		this.dateDelete = dateDelete;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] dados) {
		this.dados = dados;
	}
	
	
}
