package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroexemplo.exception.ResourceNotFoundException;
import com.teste.primeiroexemplo.model.Produto;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Método que retorna uma lista de produtos.
     * 
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Retorna um produto com base no id
     * 
     * @param id do produto que será encontrado
     * @return retorna um produto caso seja encontrado. Optional
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Método que adiciona um produto.
     * 
     * @param produto que será adicionado
     * @return Retorna um produto.
     */
    public Produto adicionar(Produto produto) {

        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Remove um produto caso o id passado no parâmetro exista.
     * 
     * @param id que será deletado do banco
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Método que atualiza o produto na lista
     * 
     * @param produto que será atualizado.
     * @return retorna o produto após atualizá-lo dentro da lista.
     */
    public Produto atualizar(Produto produto) {

        // 1. Encontrar o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto com o id passado não foi encontrado.");
        }

        // 2. Remover o antigo produto da lista
        deletar(produto.getId());

        // 3. Adicionar o produto atualizado na lista
        produtos.add(produto);

        return produto;
    }

}
