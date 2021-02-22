package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.LivroResponse;
import br.com.zup.casadocodigo.form.NovoLivroRequest;
import br.com.zup.casadocodigo.model.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
		Livro livro = novoLivroRequest.toModel(manager);
		manager.persist(livro);
		return new LivroResponse(livro).toString();
	}
}
