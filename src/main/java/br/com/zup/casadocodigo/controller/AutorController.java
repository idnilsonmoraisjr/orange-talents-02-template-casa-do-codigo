package br.com.zup.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.NovoAutorDto;
import br.com.zup.casadocodigo.form.NovoAutorRequest;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	AutorRepository autorRepository;

	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid NovoAutorRequest autorRequest) {
		Autor autor = autorRequest.toModel();
		autorRepository.save(autor);
		return new NovoAutorDto(autor).toString();
	}
}
