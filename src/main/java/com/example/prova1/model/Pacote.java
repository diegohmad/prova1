package com.example.prova1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Pacote {
    @Id
    private String id;

    private String destinatario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    private String status;

    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL)
    private List<Rastreamento> rastreamentos;

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
        this.status = novoStatus;
        Rastreamento rastreamento = new Rastreamento();
        rastreamento.setDataHora(dataHora);
        rastreamento.setStatus(novoStatus);
        rastreamento.setLocalizacao(localizacao);
        rastreamento.setPacote(this);
        this.rastreamentos.add(rastreamento);
    }

    public String consultarInformacoes() {
        StringBuilder info = new StringBuilder();
        info.append("ID: ").append(this.id)
            .append("\nDestinatário: ").append(this.destinatario)
            .append("\nEndereço: ").append(this.endereco.getEnderecoCompleto())
            .append("\nStatus: ").append(this.status)
            .append("\nRastreamentos: \n");

        for (Rastreamento rastreamento : this.rastreamentos) {
            info.append(rastreamento.getResumo()).append("\n");
        }
        return info.toString();
    }
}
