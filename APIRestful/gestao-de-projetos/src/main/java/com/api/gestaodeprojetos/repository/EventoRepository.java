package com.api.gestaodeprojetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gestaodeprojetos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
