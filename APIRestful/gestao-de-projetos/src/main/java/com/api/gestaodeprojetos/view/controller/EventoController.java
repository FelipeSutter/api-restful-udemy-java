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

import com.api.gestaodeprojetos.model.Evento;
import com.api.gestaodeprojetos.service.EventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public List<Evento> obterTodos() {
        return service.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Evento> obterPorId(@PathVariable Long id) {
        return service.obterPorId(id);
    }

    @PostMapping
    public Evento adicionar(@RequestBody Evento evento) {
        return service.adicionar(evento);
    }

    @PutMapping("/{id}")
    public Evento atualizar(@PathVariable Long id, @RequestBody Evento evento) {
        // evento.setId(id);
        return service.atualizar(id, evento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
