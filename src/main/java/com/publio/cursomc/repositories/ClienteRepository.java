package com.publio.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.publio.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	//readOnly=true diz que não necessita ser envolvida na transação de banco de dados
	//O que faz a transação ficar mais rápida e diminuir o looking
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
	
}
