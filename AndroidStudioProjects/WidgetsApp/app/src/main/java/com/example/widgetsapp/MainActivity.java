package com.example.widgetsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText text;
    Button converter;
    TextView pounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        text = findViewById(R.id.editText);;
        converter = findViewById(R.id.convert_button);
        pounds = findViewById(R.id.textView);

        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double kg = Double.parseDouble(text.getText().toString());
                double pounds_double = kg * 2.20462;
                pounds.setText(String.valueOf(pounds_double));
            }
        });
    }
};