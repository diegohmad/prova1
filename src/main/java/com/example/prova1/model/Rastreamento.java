package com.example.prova1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Rastreamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    private String status;

    private String localizacao;

    @ManyToOne
    @JoinColumn(name = "pacote_id", referencedColumnName = "id")
    private Pacote pacote;    

    public String getResumo() {
        return "Data/Hora: " + this.dataHora + ", Status: " + this.status + ", Localização: " + this.localizacao;
    }
}
