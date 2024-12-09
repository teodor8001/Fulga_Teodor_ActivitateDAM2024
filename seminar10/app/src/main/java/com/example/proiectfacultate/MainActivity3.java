package com.example.proiectfacultate;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.listView);
        ArrayList<Masina> listaMasina = getIntent().getParcelableArrayListExtra("listaMasina");
        ArrayAdapter<Masina> adapter = new ArrayAdapter<Masina>(getApplicationContext(), android.R.layout.simple_list_item_1, listaMasina);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Masina masinaSelectata = listaMasina.get(position);

                Toast.makeText(getApplicationContext(), masinaSelectata.toString(), Toast.LENGTH_LONG).show();
            }

        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Masina masinaDeSters = listaMasina.get(position);
                listaMasina.remove(position);
                Toast.makeText(getApplicationContext(),  masinaDeSters.toString() + " a fost sters", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}