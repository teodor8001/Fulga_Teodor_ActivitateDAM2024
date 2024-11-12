package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

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

        Intent intentMainActivity2 = getIntent();
        String text = intentMainActivity2.getStringExtra("text");
        String numarul1 = intentMainActivity2.getStringExtra("numarul1");
        String numarul2 = intentMainActivity2.getStringExtra("numarul2");
        int suma = Integer.parseInt(numarul1) + Integer.parseInt(numarul2);
        Toast.makeText(this, text + " " + String.valueOf(suma), Toast.LENGTH_SHORT).show();
    }


}