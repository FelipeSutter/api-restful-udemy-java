package com.teste.primeiroexemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.primeiroexemplo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
