package br.com.zup.casadocodigo.dto;

import java.math.BigDecimal;

import br.com.zup.casadocodigo.model.Livro;

public class DetalhaSiteLivroResponse {

	private String titulo;
	private DetalhaAutorResponse autor;
	private String isbn;
	private int numeroPaginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;

	public DetalhaSiteLivroResponse(Livro livro) {
		
		this.autor = new DetalhaAutorResponse(livro.getAutor());
		this.titulo = livro.getTitulo();
		this.isbn = livro.getIsbn();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
	}

	public String getTitulo() {
		return titulo;
	}

	public DetalhaAutorResponse getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}
}
