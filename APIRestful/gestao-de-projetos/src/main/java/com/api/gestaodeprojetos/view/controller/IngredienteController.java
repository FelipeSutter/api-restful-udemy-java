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

import com.api.gestaodeprojetos.model.Ingrediente;
import com.api.gestaodeprojetos.service.IngredienteService;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService service;

    @GetMapping
    public List<Ingrediente> obterTodos() {
        return service.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Ingrediente> obterPorId(@PathVariable Long id) {
        return service.obterPorId(id);
    }

    @PostMapping
    public Ingrediente adicionar(@RequestBody Ingrediente ingrediente) {
        return service.adicionar(ingrediente);
    }

    @PutMapping("/{id}")
    public Ingrediente atualizar(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
        return service.atualizar(id, ingrediente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
