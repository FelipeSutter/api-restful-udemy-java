package br.com.tech4me.produtosms.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.produtosms.shared.ProdutoDto;

public interface ProdutoService {

    ProdutoDto criarProduto(ProdutoDto produto);

    List<ProdutoDto> obterTodos();

    Optional<ProdutoDto> obterPorId(Integer id);

    void deletarProduto(Integer id);

    ProdutoDto atualizaProduto(Integer id, ProdutoDto produto);

}
