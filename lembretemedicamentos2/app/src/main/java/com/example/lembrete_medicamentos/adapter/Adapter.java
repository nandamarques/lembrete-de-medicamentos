package com.example.lembrete_medicamentos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lembrete_medicamentos.R;
import com.example.lembrete_medicamentos.model.Medicamento;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Medicamento> lista;
    private LayoutInflater inflater;

    public Adapter(Context context, List<Medicamento> lista) {
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_lista_main, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Medicamento med = this.lista.get(position);
        holder.getNome().setText(med.getNome());
        holder.getDose().setText(med.getDosagem());
        holder.getFrequencia().setText(med.getFrequencia().toString());
        //holder.getHora().setText(med.getHora().toString());
        //holder.getData().setText(med.getData().toString());
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }
}


class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView nome;
    private TextView dose;
    private TextView frequencia;

    private TextView data;
    private TextView hora;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.item_nome_remedio);
        dose = itemView.findViewById(R.id.item_dose_remedio);
        frequencia = itemView.findViewById(R.id.item_frequencia_remedio);
        hora = itemView.findViewById(R.id.add_text_hora);
        data = itemView.findViewById(R.id.add_text_data);
        itemView.setOnClickListener(this);
    }

    public TextView getNome() {
        return nome;
    }

    public TextView getDose() {
        return dose;
    }

    public TextView getFrequencia() {
        return frequencia;
    }

    public TextView getHora() {
        return hora;
    }

    public TextView getData() {
        return data;
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), nome.getText() + "", Toast.LENGTH_LONG).show();
    }
}