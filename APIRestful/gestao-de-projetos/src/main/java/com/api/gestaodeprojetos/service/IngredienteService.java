package com.api.gestaodeprojetos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaodeprojetos.model.Ingrediente;
import com.api.gestaodeprojetos.repository.IngredienteRepository;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository repository;

    public List<Ingrediente> obterTodos() {
        return repository.findAll();
    }

    public Optional<Ingrediente> obterPorId(Long id) {
        return repository.findById(id);
    }

    public Ingrediente adicionar(Ingrediente ingrediente) {
        return repository.save(ingrediente);
    }

    public Ingrediente atualizar(Long id, Ingrediente ingrediente) {
        ingrediente.setId(id);
        return repository.save(ingrediente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
