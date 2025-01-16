package com.example.proiectfacultate;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

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
        Button buttonVeziLista = findViewById(R.id.buttonVeziLista);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference masiniRef = database.getReference("masini");

    // Creează un obiect Masina
        Masina masinaNoua = new Masina("Toyota", true, 200, "Corolla");

    // Adaugă obiectul în baza de date
        String idMasina = masiniRef.push().getKey();
        masiniRef.child(idMasina).setValue(masinaNoua).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.d("Firebase", "Mașina a fost adăugată cu succes!");
            } else {
                Log.e("Firebase", "Eroare la adăugarea mașinii: ", task.getException());
            }
        });

        // Read from the database
        masiniRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Masina masina = dataSnapshot.getValue(Masina.class);
                if (masina != null) {
                    Log.d(TAG, "Masina: " + masina.toString());
                } else {
                    Log.e(TAG, "Eroare la conversia obiectului Masina!");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        buttonToGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AdaugareMasinaActivity.class);
                startActivityForResult(it, 403);
            }
        });

        buttonVeziLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}