package br.com.zup.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import br.com.zup.casadocodigo.model.Autor;

public class NovoAutorRequest {

	@NotBlank
	private String nome;
	@NotBlank @Email @UniqueValue(domainClass = Autor.class,fieldName="email")
	private String email;
	@NotBlank @Size(max = 400)
	private String descricao;
	
	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	
	/**
	 * 
	 * @return Método responável retornar um objeto do tipo Autor com os atributos passados na requisição.
	 */
	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
	
}
