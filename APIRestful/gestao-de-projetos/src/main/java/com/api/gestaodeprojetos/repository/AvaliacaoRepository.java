package com.api.gestaodeprojetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gestaodeprojetos.model.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

}
