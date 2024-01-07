package com.api.gestaodeprojetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gestaodeprojetos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
