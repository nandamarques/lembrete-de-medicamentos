package com.example.lembrete_medicamentos.dao;

import com.example.lembrete_medicamentos.model.Medicamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAO {

    public static List<Medicamento> medicamentos = new ArrayList<>();


    public static void adicionarMedicamento(Medicamento medicamento){
        medicamentos.add(medicamento);
    }

    public static List<Medicamento> listarTodos() {
        return medicamentos;
    }

    public static void geradorDeRemedios(){
//        adicionarMedicamento(new Medicamento(1l,"Paracetamol", "100g",2, LocalDateTime.now().withHour(14).withMinute(30), LocalDateTime.now()));
//        adicionarMedicamento(new Medicamento(2l,"Ibuprofeno", "200g",4, LocalDateTime.now().withHour(14).withMinute(30), LocalDateTime.now()));
//        adicionarMedicamento(new Medicamento(3l,"Dipirona", "500g",1, LocalDateTime.now().withHour(14).withMinute(30), LocalDateTime.now()));
//        adicionarMedicamento(new Medicamento(4l,"Seila", "300g",6, LocalDateTime.now().withHour(14).withMinute(30), LocalDateTime.now()));
    }

}
