package com.example.lembrete_medicamentos.dao;

import com.example.lembrete_medicamentos.model.Medicamento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAO {

    public static List<Medicamento> medicamentos = new ArrayList<>();


    public void adicionarMedicamento(Medicamento medicamento){
        medicamentos.add(medicamento);
    }

    public static List<Medicamento> listarTodos() {
        return medicamentos;
    }

    public void geradorDeRemedios(){
//        adicionarMedicamento(new Medicamento(1l,"Paracetamol", "100g",LocalDate.);
//        adicionarMedicamento(new Medicamento(2l,"Ibuprofeno", LocalDate.of(2023,02,24)));
//        adicionarMedicamento(new Medicamento(3l,"Depakote", LocalDate.of(2023,03,9)));
//        adicionarMedicamento(new Medicamento(4l,"Rivotril", LocalDate.of(2023,04,3)));
    }

}
