package com.example.prova1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;

    private String numero;

    private String cidade;

    private String estado;

    private String cep;

    public String getEnderecoCompleto() {
        return this.rua + ", " + this.numero + ", " + this.cidade + ", " + this.estado + ", " + this.cep;
    }
}
