package br.com.zup.casadocodigo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.DetalhaSiteLivroResponse;
import br.com.zup.casadocodigo.dto.LivroResponse;
import br.com.zup.casadocodigo.form.NovoLivroRequest;
import br.com.zup.casadocodigo.model.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
		Livro livro = novoLivroRequest.toModel(manager);
		manager.persist(livro);
		return new LivroResponse(livro).toString();
	}
	
	@GetMapping
	public List<LivroResponse> listaTodos() {
		return manager.createQuery("SELECT l FROM Livro l", Livro.class)
				.getResultStream()
				.map(LivroResponse::new)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhaSiteLivroResponse> detalhaLivro(@PathVariable Long id) {
		
		Optional<Livro> livro = Optional.ofNullable(manager.find(Livro.class, id));
		
		if(livro.isPresent()) {
			return ResponseEntity.ok(new DetalhaSiteLivroResponse(livro.get()));
		}
		return ResponseEntity.notFound().build();
	}
}
