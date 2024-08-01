package com.example.prova1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.prova1.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
}
