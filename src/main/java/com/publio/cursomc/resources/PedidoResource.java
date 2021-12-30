package com.publio.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publio.cursomc.domain.Pedido;
import com.publio.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	//O Autowired serve para instaciar o repositório( inversão de dependência ou injeção de controle.
	@Autowired
	private PedidoService service;
	
	// O @PathVariable serve para fazer com que o spring saiba que o id da url value="/{id}" vai ter que ir para o id do atributo Integer id
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}


