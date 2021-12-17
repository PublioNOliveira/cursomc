package com.publio.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publio.cursomc.domain.Categoria;
import com.publio.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	//O Autowired serve para instaciar o repositório( inversão de dependência ou injeção de controle.
	@Autowired
	private CategoriaService service;
	
	// O @PathVariable serve para fazer com que o spring saiba que o id da url value="/{id}" vai ter que ir para o id do atributo Integer id
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
