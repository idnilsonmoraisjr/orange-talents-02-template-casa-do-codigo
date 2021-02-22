package br.com.zup.casadocodigo.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.casadocodigo.config.validacao.ExistsId;
import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;

public class NovoLivroRequest {
	
	@NotBlank @UniqueValue(domainClass = Livro.class,fieldName="titulo")
	private String titulo;
	@NotBlank 
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull 
	@Min(20)
	private BigDecimal preco;
	@NotNull 
	@Min(100)
	private int numeroPaginas;
	@NotNull 
	@UniqueValue(domainClass = Livro.class,fieldName="isbn")
	private String isbn;
	@NotNull 
	@Future
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataDePublicacao;
	@NotNull 
	@ExistsId(domainClass = Categoria.class, fieldName="id")
	private Long idCategoria;
	@NotNull 
	@ExistsId(domainClass = Autor.class, fieldName="id")
	private Long idAutor;
	
	public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroPaginas, @NotNull String isbn,
			@NotNull @Future LocalDate dataDePublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	/**
	 * 
	 * @return Método responsável por retornar um objeto do tipo Livro com os atributos passados na requisição.
	 */
	
	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		
        Assert.state(autor != null, "Valor de Autor está nulo");
        Assert.state(categoria != null, "Valor de Categoria está nulo");
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas,
				isbn, dataDePublicacao, categoria, autor);
	}


}
