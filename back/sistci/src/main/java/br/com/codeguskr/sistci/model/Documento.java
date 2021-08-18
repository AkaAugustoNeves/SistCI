package br.com.codeguskr.sistci.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.codeguskr.sistci.controller.form.DocumentoForm;

@Entity
public class Documento {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
	private LocalDate date = LocalDate.now();
	private String destino;
	private String assunto;
	private String conteudo;
	@ManyToOne
	private TipoDocumento tipoDocumento;
	@ManyToOne
	private Coordenacao coordenacao;
	@ManyToOne
	private Usuario usuario;
	@OneToMany(mappedBy = "documento")
	private List<Anexo> anexos = new ArrayList<>();
	
	public Documento() {
		// TODO Auto-generated constructor stub
	}
	public Documento(DocumentoForm form, Coordenacao coordenacao , TipoDocumento tipoDocumento, Usuario usuario) {
		this.destino = form.getDestino();
		this.assunto = form.getAssunto();
		this.conteudo = form.getAssunto();
		this.coordenacao = coordenacao;
		this.tipoDocumento = tipoDocumento;
		this.usuario = usuario;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}
	public Coordenacao getCoordenacao() {
		return coordenacao;
	}
	public void setCoordenacao(Coordenacao coordenacao) {
		this.coordenacao = coordenacao;
	}
	
	
	
}
