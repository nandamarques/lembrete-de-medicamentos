package com.example.lembrete_medicamentos.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;

public class Medicamento implements Parcelable {

    private Long id;
    private String nome;
    private String dosagem;

    private LocalDateTime data;
    private LocalDateTime hora;

    public Medicamento(){
    }

    public Medicamento(Long id, String nome, String dosagem, LocalDateTime data, LocalDateTime hora) {
        this.id = id;
        this.nome = nome;
        this.dosagem = dosagem;
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

    protected Medicamento(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        nome = in.readString();
        dosagem = in.readString();
        data = (LocalDateTime) in.readSerializable();
        hora = (LocalDateTime) in.readSerializable();
    }

    public static final Creator<Medicamento> CREATOR = new Creator<Medicamento>() {
        @Override
        public Medicamento createFromParcel(Parcel in) {
            return new Medicamento(in);
        }

        @Override
        public Medicamento[] newArray(int size) {
            return new Medicamento[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(nome);
        parcel.writeString(dosagem);
        parcel.writeSerializable(data);
        parcel.writeSerializable(hora);
    }
}

