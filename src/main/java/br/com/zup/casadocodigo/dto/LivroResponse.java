package br.com.zup.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.casadocodigo.model.Livro;

public class LivroResponse {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int numeroPaginas;
	private String isbn;
	private LocalDate dataDePublicacao;
	private CategoriaResponse categoria;
	private AutorResponse autor;
	
	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.categoria = new CategoriaResponse(livro.getCategoria());
		this.autor = new AutorResponse(livro.getAutor());
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public CategoriaResponse getCategoria() {
		return categoria;
	}

	public AutorResponse getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		return "LivroResponse [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario
				+ ", preco=" + preco + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataDePublicacao="
				+ dataDePublicacao + ", categoria=" + categoria + ", autor=" + autor + "]";
	}
}
