package com.teste.primeiroexemplo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    /**
     * Método que retorna uma lista de produtos.
     * 
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos() {
        return repository.obterTodos();
    }

    /**
     * Retorna um produto com base no id
     * 
     * @param id do produto que será encontrado
     * @return retorna um produto caso seja encontrado. Optional
     */
    public Optional<Produto> obterPorId(Integer id) {
        return repository.obterPorId(id);
    }

    /**
     * Método que adiciona um produto.
     * 
     * @param produto que será adicionado
     * @return Retorna um produto.
     */
    public Produto adicionar(Produto produto) {
        // Colocar regras de negócio aqui.
        return repository.adicionar(produto);
    }

    /**
     * Remove um produto caso o id passado no parâmetro exista.
     * 
     * @param id que será deletado do banco
     */
    public void deletar(Integer id) {
        repository.deletar(id);
    }

    /**
     * Método que atualiza o produto na lista
     * 
     * @param produto que será atualizado.
     * @param id do produto específico que será atualizado.
     * @return retorna o produto após atualizá-lo dentro da lista.
     */
    public Produto atualizar(Integer id, Produto produto) {
        produto.setId(id);
        return repository.atualizar(produto);
    }

}
