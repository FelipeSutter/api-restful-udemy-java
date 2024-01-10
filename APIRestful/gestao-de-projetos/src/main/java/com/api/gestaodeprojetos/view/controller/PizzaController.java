package com.api.gestaodeprojetos.view.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gestaodeprojetos.model.Pizza;
import com.api.gestaodeprojetos.service.PizzaService;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService service;

    @GetMapping
    public List<Pizza> obterTodos() {
        return service.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pizza> obterPorId(@PathVariable Long id) {
        return service.obterPorId(id);
    }

    @PostMapping
    public Pizza adicionar(@RequestBody Pizza pizza) {
        return service.adicionar(pizza);
    }

    @PutMapping("/{id}")
    public Pizza atualizar(@PathVariable Long id, @RequestBody Pizza pizza) {
        return service.atualizar(id, pizza);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
