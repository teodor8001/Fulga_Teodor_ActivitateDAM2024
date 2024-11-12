package com.example.pregatire_lucrare_3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PrelucrareActivity extends AppCompatActivity {

    TextView nume, adresa, profit, cheltuieli, afisare;
    RadioButton radioButton;
    Spinner spinner;
    RatingBar ratingBar;
    Switch switchul;
    Button button;
    Firma firmaMea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prelucrare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nume = findViewById(R.id.numeEditText);
        adresa = findViewById(R.id.adresaEditText);
        profit = findViewById(R.id.profitEditText);
        cheltuieli = findViewById(R.id.cheltuieliEditText);
        switchul = findViewById(R.id.switch1);
        radioButton = findViewById(R.id.radioButton);
        spinner = findViewById(R.id.spinner);
        ratingBar = findViewById(R.id.ratingBar);
        button = findViewById(R.id.button);
        afisare = findViewById(R.id.afisare);

        ArrayList<Firma> listaFirme = new ArrayList<Firma>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firmaMea = new Firma(nume.getText().toString(),
                        adresa.getText().toString(),
                        Integer.parseInt(profit.getText().toString()),
                        Integer.parseInt(cheltuieli.getText().toString()),
                        switchul.isChecked());
                listaFirme.add(firmaMea);
                Log.d("firmaMea", firmaMea.toString());
                Toast.makeText(getApplicationContext(), String.valueOf(firmaMea.getRating()), Toast.LENGTH_LONG).show();
                afisare.setText(firmaMea.toString());
            }
        });

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        Toast.makeText(getApplicationContext(), firmaMea.toString(), Toast.LENGTH_SHORT).show();
//    }
}