package br.com.zup.casadocodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import br.com.zup.casadocodigo.model.Pais;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class,fieldName="nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
