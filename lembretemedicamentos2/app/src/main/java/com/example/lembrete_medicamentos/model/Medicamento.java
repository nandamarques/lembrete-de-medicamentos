package com.example.lembrete_medicamentos.model;

import java.time.LocalDateTime;

public class Medicamento {

    private Long id;
    private String nome;
    private String dosagem;

    private Integer frequencia;

    private LocalDateTime data;
    private LocalDateTime hora;

    public Medicamento(){

    }

    public Medicamento(Long id, String nome, String dosagem, Integer frequencia, LocalDateTime data, LocalDateTime hora) {
        this.id = id;
        this.nome = nome;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
        this.data = data;
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

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
