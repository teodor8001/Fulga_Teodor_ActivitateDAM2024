package com.example.proiectfacultate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugareMasinaActivity extends AppCompatActivity {

    Button startButton;
    EditText brandEditText;
    EditText modelEditText;
    EditText hpEditText;
    CheckBox isSport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        startButton = findViewById(R.id.startButton);
        brandEditText = findViewById(R.id.brand);
        modelEditText = findViewById(R.id.model);
        hpEditText = findViewById(R.id.caiPutere);
        isSport = findViewById(R.id.isSport);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Masina masina1 = new Masina(brandEditText.getText().toString(),
                        isSport.isChecked(),
                        Integer.parseInt(hpEditText.getText().toString()),
                        modelEditText.getText().toString());
                Toast.makeText(getApplicationContext(), masina1.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}