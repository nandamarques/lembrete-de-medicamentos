package com.example.lembrete_medicamentos.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lembrete_medicamentos.R;
import com.example.lembrete_medicamentos.activities.AddMedicamentoActivity;
import com.example.lembrete_medicamentos.dao.MedicamentoDAO;
import com.example.lembrete_medicamentos.model.Medicamento;
import com.example.lembrete_medicamentos.util.FormatadorDataHora;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Medicamento> lista;
    private LayoutInflater inflater;

    Context context;

    public Adapter(Context context, List<Medicamento> lista) {
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_lista_main, parent, false);
        Log.d("Adapter", "Criando uma View nova");
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Medicamento med = this.lista.get(position);
        holder.getNome().setText(med.getNome());
        holder.getDose().setText(med.getDosagem());
        holder.getData().setText(med.getData() != null ? med.getData().toString() : "");
        holder.getHora().setText(med.getHora() != null ? med.getHora().toString() : "");
//        holder.getData().setText(med.getData().toString());
//        holder.getHora().setText(med.getHora().toString());
        Log.d("Adapter", "Fazendo um Bind em uma View");

        int pos = position;
        holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(context, AddMedicamentoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("MEDICAMENTO", med);
                intent.putExtra("POS", pos);
                context.startActivity(intent);
            });
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }
}


class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView nome;
    private TextView dose;
    private TextView data;
    private TextView hora;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.item_nome_remedio);
        dose = itemView.findViewById(R.id.item_dose_remedio);
        hora = itemView.findViewById(R.id.item_horarios_remedio);
        data = itemView.findViewById(R.id.item_data_remedio);

    }

    public TextView getNome() {
        return nome;
    }

    public TextView getDose() {
        return dose;
    }

    public TextView getHora() {
        return hora;
    }

    public TextView getData() {
        return data;
    }

}