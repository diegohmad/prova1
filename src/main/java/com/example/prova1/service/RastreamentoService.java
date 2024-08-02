package com.example.prova1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prova1.model.Rastreamento;
import com.example.prova1.repository.RastreamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RastreamentoService {

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<Rastreamento> findAll() {
        return (List<Rastreamento>) rastreamentoRepository.findAll();
    }

    public List<Rastreamento> findByPacoteId(Long pacoteId) {
        return rastreamentoRepository.findByPacoteId(pacoteId);
    }

    public Optional<Rastreamento> findById(Long id) {
        return rastreamentoRepository.findById(id);
    }

    public Rastreamento save(Rastreamento rastreamento) {
        return rastreamentoRepository.save(rastreamento);
    }

    public void deleteById(Long id) {
        rastreamentoRepository.deleteById(id);
    }
}
