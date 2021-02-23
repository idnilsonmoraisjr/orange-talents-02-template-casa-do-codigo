package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.CategoriaResponse;
import br.com.zup.casadocodigo.form.NovaCategoriaRequest;
import br.com.zup.casadocodigo.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid NovaCategoriaRequest categoriaRequest) {
		Categoria categoria = new Categoria(categoriaRequest.getNome());
		manager.persist(categoria);
		return new CategoriaResponse(categoria).toString();
	}
}
