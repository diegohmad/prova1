package com.example.prova1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.prova1.model.Rastreamento;
import com.example.prova1.service.RastreamentoService;

import java.util.List;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @GetMapping
    public List<Rastreamento> findAll() {
        return rastreamentoService.findAll();
    }

    @GetMapping("/{pacoteId}")
    public List<Rastreamento> findByPacoteId(@PathVariable Long pacoteId) {
        return rastreamentoService.findByPacoteId(pacoteId);
    }

    @PostMapping
    public Rastreamento save(@RequestBody Rastreamento rastreamento) {
        return rastreamentoService.save(rastreamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (rastreamentoService.findById(id).isPresent()) {
            rastreamentoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
