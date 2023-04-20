package com.example.lembrete_medicamentos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lembrete_medicamentos.R;
import com.example.lembrete_medicamentos.dao.MedicamentoDAO;
import com.example.lembrete_medicamentos.model.Medicamento;
import com.google.android.material.textfield.TextInputEditText;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddMedicamentoActivity extends AppCompatActivity {

    private MedicamentoDAO medDao = new MedicamentoDAO();
    private TextInputEditText nomeMedicamento;
    private TextInputEditText doseMedicamento;

    private EditText frequenciaMedicamento;
    private Button horarioMedicamento;

    private Button dataMedicamento;
    private TimePickerDialog mTimePickerDialog;
    private DatePickerDialog mDatePickerDialog;

    private TextView hora;
    private TextView data;
    private Button salvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicamento);

        nomeMedicamento = findViewById(R.id.add_campo_nome);
        doseMedicamento = findViewById(R.id.add_campo_dose);
        salvar = findViewById(R.id.add_button_salvar);
        horarioMedicamento = findViewById(R.id.add_button_horario);
        dataMedicamento =  findViewById(R.id.add_button_data);
        hora = findViewById(R.id.add_text_hora);
        data = findViewById(R.id.add_text_data);



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


        salvar.setOnClickListener(v -> {
            Medicamento med = new Medicamento();
            med.setNome(nomeMedicamento.getText().toString());
            med.setDosagem(doseMedicamento.getText().toString());
            med.setFrequencia(Integer.parseInt(frequenciaMedicamento.getText().toString()));
            med.setData(LocalDateTime.parse((CharSequence) data, formatadorData));
            med.setHora(LocalDateTime.parse((CharSequence) hora, formatadorHora));
            MainActivity.meds.add(med);
            finish();
        });
    }
}

