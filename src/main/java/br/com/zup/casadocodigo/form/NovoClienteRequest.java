package br.com.zup.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.casadocodigo.config.validacao.CpfOuCnpj;
import br.com.zup.casadocodigo.config.validacao.ExistsId;
import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import br.com.zup.casadocodigo.model.Cliente;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;

public class NovoClienteRequest {

	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CpfOuCnpj
	@UniqueValue(domainClass = Cliente.class,fieldName="documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName="id")
	private Long idPais;
	@ExistsId(domainClass = Estado.class, fieldName="id")
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class,fieldName="email")
	private String email;
	@NotBlank
	private String cep;
	
	public NovoClienteRequest(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long idPais,
			Long idEstado, @NotBlank String telefone, @NotBlank String email, @NotBlank String cep) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
	}

	
	/**
	 * 
	 * @return Método responsável por retornar um objeto do tipo Cliente com os atributos passados na requisição.
	 */
	public Cliente toModel(EntityManager manager) {
		
		@NotNull Pais pais = manager.find(Pais.class, idPais);
		Estado estado = null;
		
		 Assert.state(pais != null, "Valor de País está nulo");
		 if(pais.contemEstados(manager) && idEstado == null) {
			 
			 throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					 "Para este País é necessário informar um Estado!");
		 } else if(idEstado != null) {
			 
			 estado =  manager.find(Estado.class, idEstado);
			 Assert.state(estado.pertenceAo(pais), "Este estado não pertence a este país");
		 }

		 return new Cliente.ClienteBuilder(this.nome, this.sobrenome,
				 this.documento, this.endereco, this.complemento,
				 this.cidade, pais, this.telefone, this.email, this.cep)
				 .estado(estado)
				 .build();
	}
}
