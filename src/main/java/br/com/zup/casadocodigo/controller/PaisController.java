package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.PaisResponse;
import br.com.zup.casadocodigo.form.NovoPaisRequest;
import br.com.zup.casadocodigo.model.Pais;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid NovoPaisRequest novoPaisRequest) {
		Pais pais = new Pais(novoPaisRequest.getNome());
		manager.persist(pais);
		return new PaisResponse(pais).toString();
	}
}
