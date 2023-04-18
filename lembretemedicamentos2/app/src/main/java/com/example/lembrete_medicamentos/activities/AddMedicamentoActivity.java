package com.example.lembrete_medicamentos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.lembrete_medicamentos.R;
import com.example.lembrete_medicamentos.dao.MedicamentoDAO;
import com.example.lembrete_medicamentos.model.Medicamento;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class AddMedicamentoActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private MedicamentoDAO medDao = new MedicamentoDAO();
    private TextInputEditText nomeMedicamento;
    private TextInputEditText doseMedicamento;

    private Button frequenciaMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicamento);

        nomeMedicamento = findViewById(R.id.add_campo_nome);
        doseMedicamento = findViewById(R.id.add_campo_dose);
        Button salvar = findViewById(R.id.add_button_salvar);

        String nomeMedicamentoValue = nomeMedicamento.getText().toString();
        String doseMedicamentoValue = doseMedicamento.getText().toString();
        String text = frequenciaMedicamento.getText().toString();
//        Integer frequenciaMedicamento = Integer.parseInt(addFrequencia.getText().toString());frequenciaMedicamento = Integer.parseInt(addFrequencia.getText().toString());
//
//
//        salvar.setOnClickListener(v -> {
//            medDao.adicionarMedicamento(1l,nomeMedicamentoValue,doseMedicamentoValue,frequenciaMedicamento);
//        });
//
//    }


//    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
//        String time = "You picked the following time: "+hourOfDay+"h"+minute+"m"+second;
//        timeTextView.setText(time);
//    }
//

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hora, int minuto) {
        Toast.makeText(AddMedicamentoActivity.this, hora + ":" + minuto, Toast.LENGTH_SHORT).show();
        Calendar now = Calendar.getInstance();

        now.set(Calendar.HOUR, hora);
        now.set(Calendar.MINUTE, minuto);

        TimePickerDialog dialog = new TimePickerDialog(
                AddMedicamentoActivity.this,
                this,
                now.get(Calendar.HOUR),
                now.get(Calendar.MINUTE),
                true
        );
        dialog.show();

    }

//    @Override
//    public void onCancel(DialogInterface dialogInterface) {
//
//    }
}