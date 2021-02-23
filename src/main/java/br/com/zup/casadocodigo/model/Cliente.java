package br.com.zup.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String email;
	@NotBlank
	private String cep;

	
	private Cliente(ClienteBuilder builder) {
		this.nome = builder.nome;
		this.sobrenome = builder.sobrenome;
		this.documento = builder.documento;
		this.endereco = builder.endereco;
		this.complemento = builder.complemento;
		this.cidade = builder.cidade;
		this.pais = builder.pais;
		this.telefone = builder.telefone;
		this.email = builder.email;
		this.cep = builder.cep;
		this.estado = builder.estado;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getCep() {
		return cep;
	}

	public static class ClienteBuilder {

		private String nome;
		private String sobrenome;
		private String documento;
		private String endereco;
		private String complemento;
		private String cidade;
		private Pais pais;
		private Estado estado;
		private String telefone;
		private String email;
		private String cep;

		public ClienteBuilder(String nome, String sobrenome, String documento, String endereco, String complemento,
				 String cidade, Pais pais, String telefone, String email, String cep) {
			this.nome = nome;
			this.sobrenome = sobrenome;
			this.documento = documento;
			this.endereco = endereco;
			this.complemento = complemento;
			this.cidade = cidade;
			this.pais = pais;
			this.telefone = telefone;
			this.email = email;
			this.cep = cep;
		}
		
		public ClienteBuilder estado(Estado estado) {
			this.estado = estado;
			return this;
		}
		
		public Cliente build() {
			Cliente cliente = new Cliente(this);
			return cliente;
		}
	}
}
