package br.com.zup.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.CategoriaDto;
import br.com.zup.casadocodigo.form.NovaCategoriaRequest;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid NovaCategoriaRequest categoriaRequest) {
		Categoria categoria = new Categoria(categoriaRequest.getNome());
		categoriaRepository.save(categoria);
		return new CategoriaDto(categoria).toString();
	}
}
