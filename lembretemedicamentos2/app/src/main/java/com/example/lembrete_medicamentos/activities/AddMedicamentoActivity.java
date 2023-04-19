package com.example.lembrete_medicamentos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.lembrete_medicamentos.R;
import com.example.lembrete_medicamentos.dao.MedicamentoDAO;
import com.example.lembrete_medicamentos.model.Medicamento;
import com.google.android.material.textfield.TextInputEditText;

import java.time.LocalDateTime;
import java.util.Calendar;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicamento);

        nomeMedicamento = findViewById(R.id.add_campo_nome);
        doseMedicamento = findViewById(R.id.add_campo_dose);
        Button salvar = findViewById(R.id.add_button_salvar);

        salvar.setOnClickListener(v -> {
            Medicamento meds = new Medicamento();
            meds.setNome(nomeMedicamento.getText().toString());
            meds.setDosagem(doseMedicamento.getText().toString());
            //resolver conversões abaixo
//            meds.getFrequencia(frequenciaMedicamento.getText().toString()));
//            meds.getHora(horarioMedicamento.getText().toString());
                MainActivity.meds.add(meds);
                finish();
        });

        horarioMedicamento = findViewById(R.id.add_button_horario);
        dataMedicamento =  findViewById(R.id.add_button_data);
        hora = findViewById(R.id.add_text_horario);
        data = findViewById(R.id.add_text_data);
        mTimePickerDialog = new TimePickerDialog(this, (timePicker, hourOfDay, minute) ->
                hora.setText(String.format("%02d:%02d", hourOfDay, minute)),
                12, 0, true);

        mDatePickerDialog = new DatePickerDialog(this, (datePicker, year, month, dayOfMonth) ->
                data.setText(String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)),
                LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());

        horarioMedicamento.setOnClickListener(view -> mTimePickerDialog.show());
        dataMedicamento.setOnClickListener(view -> mDatePickerDialog.show());


//        horarioMedicamento.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addHorario(view);
//
//            }
//        });
    }
//
//    private int hora, minuto;
//    TimePicker timePicker;
//
//    private void addHorario(View view) {
//        initTimeData();
//        onTimeSet(timePicker, hora, minuto);
//        Toast.makeText(AddMedicamentoActivity.this, hora + ":" + minuto, Toast.LENGTH_SHORT).show();
//    }
//
//
//    private void initTimeData() {
//        Calendar c = Calendar.getInstance();
//        hora = c.get(Calendar.HOUR);
//        minuto = c.get(Calendar.MINUTE);
//    }
//
//    @Override
//    public void onTimeSet(TimePicker timePicker, int i, int i1) {
//
//        Calendar now = Calendar.getInstance();
//        now.set(hora, minuto);
//
//
//        TimePickerDialog dialog = new TimePickerDialog(
//                AddMedicamentoActivity.this,
//                this,
//                now.get(Calendar.HOUR),
//                now.get(Calendar.MINUTE),
//                true
//        );
//        dialog.setTitle("Horário da medicação");
//        dialog.show();
//    }
//

}

