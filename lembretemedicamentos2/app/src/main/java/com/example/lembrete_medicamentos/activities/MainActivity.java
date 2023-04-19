package com.example.lembrete_medicamentos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lembrete_medicamentos.R;
import com.example.lembrete_medicamentos.adapter.Adapter;
import com.example.lembrete_medicamentos.model.Medicamento;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button salvar;

    private static final String CHANNEL_ID = "id";

    public static List<Medicamento> meds = new ArrayList<>();
    public RecyclerView recyclerView;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //salvar();
        //createNotificationChannel();
        //notification();

        recyclerView = findViewById(R.id.main_recycleview_lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.main_fab_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddMedicamentoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        recyclerView = findViewById(R.id.main_recycleview_lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(this, meds));
        super.onResume();

    }

    /*private void salvar() {
        salvar = findViewById(R.id.main_button);
        salvar.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            intent.putExtra("Texto_Digitado", "teste");
            startActivity(intent);
        });
    }*/

    private void notification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent p1 = PendingIntent.getActivity(this,345,intent,PendingIntent.FLAG_MUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Lembrete de Remédio")
                .setContentText("Está no horário de tomar seu remédio")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).setContentIntent(p1);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(123, builder.build());
        
        
    }
    private void createNotificationChannel() {
        CharSequence name = getString(R.string.channel_name);
        String description = getString(R.string.channel_description);
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
        channel.setDescription(description);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    public void Notificar(View v){
        Toast.makeText(this, "Login realizado!", Toast.LENGTH_SHORT).show();
    }

//    ADICIONEI UMA PERMISSAO PARA QUE O USUARIO PERMITA O ACESSO A VIRACAO DO CELULAR
//    private static final String CHANNEL_ID = "my_channel";
//
//    private void createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = getString(R.string.channel_name);
//            String description = getString(R.string.channel_description);
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//        }
//    }
//
//    private void notification() {
//        Intent intent = new Intent(this, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("Lembrete de Remédio")
//                .setContentText("Está no horário de tomar seu remédio")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true);
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//        notificationManager.notify(123, builder.build());
//    }
//
//    public void Notificar(View view) {
//        Toast.makeText(this, "Login realizado!", Toast.LENGTH_SHORT).show();
//    }

}

