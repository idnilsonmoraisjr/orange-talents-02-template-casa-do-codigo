package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Pais;

public class PaisResponse {

	private Long id;
	private String nome;

	public PaisResponse(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "País [id=" + id + ", nome=" + nome + "]";
	}

	
}
