package com.example.prova1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prova1.model.Pacote;
import com.example.prova1.repository.PacoteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    public List<Pacote> findAll() {
        return (List<Pacote>) pacoteRepository.findAll();
    }

    public Optional<Pacote> findById(String id) {
        return pacoteRepository.findById(id);
    }

    public Pacote save(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public void deleteById(String id) {
        pacoteRepository.deleteById(id);
    }
}
