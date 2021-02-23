package br.com.zup.casadocodigo.form;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.casadocodigo.config.validacao.ExistsId;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;

public class NovoEstadoRequest {

	@NotBlank
	private String nome;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName="id")
	private Long idPais;

	public NovoEstadoRequest(@NotBlank String nome, @NotBlank Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}
	
	/**
	 * 
	 * @return Método responsável por retornar um objeto do tipo Estado com os atributos passados na requisição.
	 */
	public Estado toModel(EntityManager manager) {
		 @NotNull Pais pais = manager.find(Pais.class, idPais);
		 
		 Assert.state(pais != null, "Valor de País está nulo");
		 Assert.state(validaSeEstadoJaExisteNoPais(manager, pais),
				 "Já existe um Estado com nome igual nesse mesmo País");
		 
		return new Estado(nome, pais);
	}
	
	/**
	 * 
	 * @return Método responsável por verificar se existe um Estado com o nome informado em um país.
	 * O Estado deve ser único para cada país.
	 */
	public boolean validaSeEstadoJaExisteNoPais(EntityManager manager, Pais pais) {
		
		List<Estado> resultado = manager.createQuery("SELECT e FROM Estado e "
				+ "WHERE e.pais = :pais and e.nome = :nome", Estado.class)
				.setParameter("pais", pais)
				.setParameter("nome", this.nome)
				.getResultList();
		if(resultado.size() >= 1) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um Estado com nome igual nesse mesmo País!");
		}
		return true;
	}
}
