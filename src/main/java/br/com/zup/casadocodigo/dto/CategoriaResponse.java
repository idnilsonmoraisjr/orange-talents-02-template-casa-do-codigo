package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Categoria;

public class CategoriaResponse{

	private Long id;
	private String nome;
	
	public CategoriaResponse(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
}