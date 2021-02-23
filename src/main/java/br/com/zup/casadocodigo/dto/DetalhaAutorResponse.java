package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Autor;

public class DetalhaAutorResponse {

	private String nome;
	private String descricao;

	public DetalhaAutorResponse(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}
