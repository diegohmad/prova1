package com.example.prova1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.prova1.model.Pacote;
import com.example.prova1.service.PacoteService;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @GetMapping
    public List<Pacote> findAll() {
        return pacoteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pacote> findById(@PathVariable Long id) {
        return pacoteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pacote save(@RequestBody Pacote pacote) {
        return pacoteService.save(pacote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pacote> update(@PathVariable Long id, @RequestBody Pacote pacote) {
        return pacoteService.findById(id)
                .map(existingPacote -> {
                    pacote.setId(existingPacote.getId());
                    return ResponseEntity.ok(pacoteService.save(pacote));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (pacoteService.findById(id).isPresent()) {
            pacoteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
