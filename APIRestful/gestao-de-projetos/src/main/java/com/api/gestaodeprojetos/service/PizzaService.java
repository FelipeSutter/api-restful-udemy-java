package com.api.gestaodeprojetos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaodeprojetos.model.Pizza;
import com.api.gestaodeprojetos.repository.PizzaRepository;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository repository;

    public List<Pizza> obterTodos() {
        return repository.findAll();
    }

    public Optional<Pizza> obterPorId(Long id) {
        return repository.findById(id);
    }

    public Pizza adicionar(Pizza pizza) {
        return repository.save(pizza);
    }

    public Pizza atualizar(Long id, Pizza pizza) {
        pizza.setId(id);
        return repository.save(pizza);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
