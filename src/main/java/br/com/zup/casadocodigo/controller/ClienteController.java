package br.com.zup.casadocodigo.controller;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.ClienteResponse;
import br.com.zup.casadocodigo.form.NovoClienteRequest;
import br.com.zup.casadocodigo.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@PersistenceContext
	EntityManager manager;
	
	@PostMapping 
	@Transactional
	public String cadastra(@RequestBody @Valid NovoClienteRequest novoClienteRequest) {
		Cliente cliente = novoClienteRequest.toModel(manager);
		manager.persist(cliente);
		
		HashMap<String, Long> clienteCadastrado = new HashMap<String, Long>();
		clienteCadastrado.put("Cliente cadastrado com o ID", new ClienteResponse(cliente).getId());
		return clienteCadastrado.toString();
	}
}
