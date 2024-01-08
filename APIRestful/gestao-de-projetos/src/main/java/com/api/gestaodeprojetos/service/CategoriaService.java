package com.api.gestaodeprojetos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaodeprojetos.model.Categoria;
import com.api.gestaodeprojetos.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> obterTodos() {
        return repository.findAll();
    }

    public Optional<Categoria> obterPorId(Long id) {
        return repository.findById(id);
    }

    public Categoria adicionar(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria categoria) {
        // categoria.setId(id);
        return repository.save(categoria);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
