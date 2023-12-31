package br.com.tech4me.produtosms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tech4me.produtosms.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
