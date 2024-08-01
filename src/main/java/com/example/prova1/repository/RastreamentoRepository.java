package com.example.prova1.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.prova1.model.Rastreamento;

@Repository
public interface RastreamentoRepository extends CrudRepository<Rastreamento, Long> {
    List<Rastreamento> findByPacoteId(String pacoteId);
}
