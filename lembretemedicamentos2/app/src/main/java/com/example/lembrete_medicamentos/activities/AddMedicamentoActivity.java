package com.example.lembrete_medicamentos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lembrete_medicamentos.R;
import com.example.lembrete_medicamentos.adapter.Adapter;
import com.example.lembrete_medicamentos.dao.MedicamentoDAO;
import com.example.lembrete_medicamentos.model.Medicamento;
import com.google.android.material.textfield.TextInputEditText;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AddMedicamentoActivity extends AppCompatActivity {

    private MedicamentoDAO medDao = new MedicamentoDAO();
    private TextInputEditText nomeMedicamento;
    private TextInputEditText doseMedicamento;
    private Button horarioMedicamento;

    private Button dataMedicamento;
    private TimePickerDialog mTimePickerDialog;
    private DatePickerDialog mDatePickerDialog;

    private EditText hora;
    private EditText data;
    private Button salvar;

    private Button excluir;

    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicamento);

        nomeMedicamento = findViewById(R.id.add_campo_nome);
        doseMedicamento = findViewById(R.id.add_campo_dose);
        horarioMedicamento = findViewById(R.id.add_button_horario);
        dataMedicamento = findViewById(R.id.add_button_data);
        hora = findViewById(R.id.add_text_hora);
        data = findViewById(R.id.add_text_data);
        salvar = findViewById(R.id.add_button_salvar);
        excluir = findViewById(R.id.add_button_excluir);

        mTimePickerDialog = new TimePickerDialog(this, (timePicker, hourOfDay, minute) ->
                hora.setText(String.format("%02d:%02d", hourOfDay, minute)),
                12, 0, true);

        mDatePickerDialog = new DatePickerDialog(this, (datePicker, year, month, dayOfMonth) ->
                data.setText(String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)),
                LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());

        horarioMedicamento.setOnClickListener(view -> mTimePickerDialog.show());
        dataMedicamento.setOnClickListener(view -> mDatePickerDialog.show());

        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");


        Intent intent = getIntent();
        position = intent.getIntExtra("POS", -1);

        if (position != -1) {
            // Obter o objeto Medicamento correspondente da lista meds
            Medicamento med = MainActivity.meds.get(position);
            // Preencher os campos com as informações do Medicamento
            nomeMedicamento.setText(med.getNome());
            doseMedicamento.setText(med.getDosagem());
            data.setText(med.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            hora.setText(med.getHora().format(DateTimeFormatter.ofPattern("HH:mm")));
            // Mudar o texto do botão salvar para "Atualizar"
            salvar.setText("Atualizar");


            // Adicionar OnClickListener para o botão salvar atualizar o Medicamento
            salvar.setOnClickListener(v -> {
                int day = Integer.parseInt(data.getText().toString().split("/")[0]);
                int mouth = Integer.parseInt(data.getText().toString().split("/")[1]);
                int year = Integer.parseInt(data.getText().toString().split("/")[2]);
                int hour = Integer.parseInt(hora.getText().toString().split(":")[0]);
                int minutes = Integer.parseInt(hora.getText().toString().split(":")[1]);
                Medicamento medAtualizado = new Medicamento();
                medAtualizado.setNome(nomeMedicamento.getText().toString());
                medAtualizado.setDosagem(doseMedicamento.getText().toString());
                medAtualizado.setData(LocalDate.of(year, mouth, day).atTime(hour, minutes));
                medAtualizado.setHora(LocalDate.of(year, mouth, day).atTime(hour, minutes));
                MainActivity.meds.set(position, medAtualizado);
                finish();
            });

            // Adicionar OnClickListener para o botão excluir remover o Medicamento
            excluir.setOnClickListener(v -> {
                MainActivity.meds.remove(position);
                finish();
            });
        } else {
            salvar.setOnClickListener(v -> {
                int day = Integer.parseInt(data.getText().toString().split("/")[0]);
                int mouth = Integer.parseInt(data.getText().toString().split("/")[1]);
                int year = Integer.parseInt(data.getText().toString().split("/")[2]);
                int hour = Integer.parseInt(hora.getText().toString().split(":")[0]);
                int minutes = Integer.parseInt(hora.getText().toString().split(":")[1]);
                Medicamento med = new Medicamento();
                med.setNome(nomeMedicamento.getText().toString());
                med.setDosagem(doseMedicamento.getText().toString());
                med.setData(LocalDate.of(year, mouth, day).atTime(hour, minutes));
                med.setHora(LocalDate.of(year, mouth, day).atTime(hour, minutes));
                MainActivity.meds.add(med);
                finish();
            });
        }


//            salvar.setOnClickListener(v -> {
//                int day = Integer.parseInt(data.getText().toString().split("/")[0]);
//                int mouth = Integer.parseInt(data.getText().toString().split("/")[1]);
//                int year = Integer.parseInt(data.getText().toString().split("/")[2]);
//                int hour = Integer.parseInt(hora.getText().toString().split(":")[0]);
//                int minutes = Integer.parseInt(hora.getText().toString().split(":")[1]);
////                Medicamento med = new Medicamento();
//                med.setNome(nomeMedicamento.getText().toString());
//                med.setDosagem(doseMedicamento.getText().toString());
//                med.setData(LocalDate.of(year, mouth, day).atTime(hour, minutes));
//                med.setHora(LocalDate.of(year, mouth, day).atTime(hour, minutes));
//                MainActivity.meds.add(med);
//                finish();
//            });
//
//
//            excluir.setOnClickListener(v -> {
//                nomeMedicamento.getText().clear();
//                doseMedicamento.getText().clear();
//                hora.getText().clear();
//                data.getText().clear();
//                finish();
//            });
//        }
//    }
    }
}

