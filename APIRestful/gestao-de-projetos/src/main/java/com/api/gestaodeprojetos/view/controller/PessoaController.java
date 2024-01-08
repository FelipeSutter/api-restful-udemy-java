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

import com.api.gestaodeprojetos.model.Pessoa;
import com.api.gestaodeprojetos.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<Pessoa> obterTodos() {
        return service.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> obterPorId(@PathVariable Long id) {
        return service.obterPorId(id);
    }

    @PostMapping
    public Pessoa adicionar(@RequestBody Pessoa pessoa) {
        return service.adicionar(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return service.atualizar(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
