package com.example.lembrete_medicamentos.model;

import java.time.LocalDate;

public class Medicamento {

    private Long id;
    private String nome;

    private LocalDate hora;

    public Medicamento(Long id, String nome, LocalDate hora) {
        this.id = id;
        this.nome = nome;
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

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }
}
