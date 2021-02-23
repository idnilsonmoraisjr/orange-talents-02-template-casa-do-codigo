package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Cliente;

public class ClienteResponse {

	private Long id;
	private String nome;
	private String sobrenome;
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	private PaisResponse pais;
	private EstadoResponse estado;
	private String telefone;
	private String email;
	private String cep;
	
	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.documento = cliente.getDocumento();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.pais = new PaisResponse(cliente.getPais());
		this.estado = new EstadoResponse(cliente.getEstado());
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.cep = cliente.getCep();
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

	public PaisResponse getPais() {
		return pais;
	}

	public EstadoResponse getEstado() {
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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", pais=" + pais
				+ ", estado=" + estado + ", telefone=" + telefone + ", email=" + email + ", cep=" + cep + "]";
	}
}
