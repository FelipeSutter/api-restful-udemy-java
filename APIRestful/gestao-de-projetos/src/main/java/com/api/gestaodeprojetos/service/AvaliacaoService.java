package com.api.gestaodeprojetos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaodeprojetos.model.Avaliacao;
import com.api.gestaodeprojetos.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public List<Avaliacao> obterTodos() {
        return repository.findAll();
    }

    public Optional<Avaliacao> obterPorId(Long id) {
        return repository.findById(id);
    }

    public Avaliacao adicionar(Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }

    public Avaliacao atualizar(Long id, Avaliacao avaliacao) {
        avaliacao.setId(id);
        return repository.save(avaliacao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
