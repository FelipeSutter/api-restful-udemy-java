package com.testes.testestdd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.testes.testestdd.model.Produto;

@Service
public class ProdutoService {

    public List<Produto> obterTodos() {
        List<Produto> produtos = new ArrayList<>();

        return produtos;
    }

    public Optional<Produto> obterPorId(Integer id) {
        Optional<Produto> produto = Optional.of(new Produto());

        return produto;
    }

    public Produto adicionar(Produto produto) {
        return produto;
    }

}
