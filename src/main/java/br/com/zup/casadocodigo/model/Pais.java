package br.com.zup.casadocodigo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;

	@Deprecated
	public Pais() {

	}

	public Pais(@NotNull String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @return Método responsável por verificar se Pais contém estados.
	 */
	public boolean contemEstados(EntityManager manager) {
		List<Estado> resultado = manager.createQuery("SELECT e FROM Estado e "
				+ "WHERE e.pais.id = :id", Estado.class)
				.setParameter("id", id)
				.getResultList();
		if(resultado.size() < 1) {
			return false;
		}
		
		return true;
	}
	
	
}
