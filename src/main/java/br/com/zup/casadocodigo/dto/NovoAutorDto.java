package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Autor;

public class NovoAutorDto {

	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private String instanteCriacao;
	
	public NovoAutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.instanteCriacao = autor.formataInstanteDeRegistro();
	}
		
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getInstanteCriacao() {
		return instanteCriacao;
	}

	@Override
	public String toString() {
		return "NovoAutorDto [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", instanteCriacao=" + instanteCriacao + "]";
	}	
}
