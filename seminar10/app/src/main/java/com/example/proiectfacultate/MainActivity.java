package com.example.proiectfacultate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Masina> listaMasina = new ArrayList<Masina>();
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
        Button buttonToGo = findViewById(R.id.buttonToGo);

        buttonToGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AdaugareMasinaActivity.class);
                startActivityForResult(it, 403);
            }
        });

        Button buttonActivity3 = findViewById(R.id.buttonActivity3);
        buttonActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), MainActivity3.class);
                it.putParcelableArrayListExtra("listaMasina", listaMasina);
                startActivity(it);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        if (bundle != null) {
            listaMasina.add(new Masina(
                    bundle.getString("brand"),
                    bundle.getBoolean("isSport"),
                    bundle.getInt("caiPutere"),
                    bundle.getString("model"))
            );
        } else {
            Log.d("BundleulMeuDeAcum", "null");
        }

        for (Masina masina: listaMasina) {
            Log.d("ArrayListContentMasina", masina.toString());
        }
    }
}