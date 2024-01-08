package com.api.gestaodeprojetos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaodeprojetos.model.Evento;
import com.api.gestaodeprojetos.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public List<Evento> obterTodos() {
        return repository.findAll();
    }

    public Optional<Evento> obterPorId(Long id) {
        return repository.findById(id);
    }

    public Evento adicionar(Evento evento) {
        return repository.save(evento);
    }

    public Evento atualizar(Long id, Evento evento) {
        // Evento.setId(id);
        return repository.save(evento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
