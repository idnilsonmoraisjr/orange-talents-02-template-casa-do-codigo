package br.com.zup.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import br.com.zup.casadocodigo.model.Categoria;

public class NovaCategoriaRequest{

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
