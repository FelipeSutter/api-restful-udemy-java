package com.api.gestaodeprojetos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaodeprojetos.model.Pessoa;
import com.api.gestaodeprojetos.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> obterTodos() {
        return repository.findAll();
    }

    public Optional<Pessoa> obterPorId(Long id) {
        return repository.findById(id);
    }

    public Pessoa adicionar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Pessoa atualizar(Long id, Pessoa pessoa) {
        pessoa.setId(id);
        return repository.save(pessoa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
