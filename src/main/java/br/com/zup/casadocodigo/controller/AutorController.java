package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.AutorResponse;
import br.com.zup.casadocodigo.form.NovoAutorRequest;
import br.com.zup.casadocodigo.model.Autor;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid NovoAutorRequest autorRequest) {
		Autor autor = autorRequest.toModel();
		manager.persist(autor);
		return new AutorResponse(autor).toString();
	}
	
	
}
