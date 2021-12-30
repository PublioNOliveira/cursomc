package com.publio.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.publio.cursomc.domain.Categoria;
import com.publio.cursomc.domain.Produto;
import com.publio.cursomc.repositories.CategoriaRepository;
import com.publio.cursomc.repositories.ProdutoRepository;
import com.publio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	//O Autowired serve para instaciar o repositório( inversão de dependência ou injeção de controle.
	@Autowired
	private ProdutoRepository repo;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		 Optional<Produto> obj = repo.findById(id);
//		 return obj.orElse(null);
		 return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName())); 
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);	
	}
}
