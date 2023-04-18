package com.example.lembrete_medicamentos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Medicamento {

    private Long id;
    private String nome;
    private String dosagem;
    private LocalDateTime hora;

    public Medicamento(Long id, String nome, String dosagem, LocalDateTime hora) {
        this.id = id;
        this.nome = nome;
        this.dosagem = dosagem;
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
}
