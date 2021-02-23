package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.EstadoResponse;
import br.com.zup.casadocodigo.form.NovoEstadoRequest;
import br.com.zup.casadocodigo.model.Estado;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) {
		Estado estado = novoEstadoRequest.toModel(manager);
		manager.persist(estado);
		return new EstadoResponse(estado).toString();
	}
}
