package com.example.lembrete_medicamentos.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatadorDataHora {
    public static final DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");

    public static LocalDateTime conversorStringData(String data){

        return LocalDateTime.parse((CharSequence) data, formatadorData);
    }

    public static LocalDateTime conversorStringHora(String hora){
        return LocalDateTime.parse((CharSequence) hora, formatadorHora);
    }
}
