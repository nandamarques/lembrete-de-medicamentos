package com.example.lembrete_medicamentos.model;

import java.time.LocalDate;

public class Medicamento {

    private Long id;
    private String nome;
    private String dosagem;
    private LocalDate hora;

    public Medicamento(Long id, String nome, String dosagem, LocalDate hora) {
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

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }
}
