package com.api.gestaodeprojetos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestaodeprojetos.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

}
