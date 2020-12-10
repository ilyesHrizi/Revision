package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    TextView Email , Password ;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Email = findViewById(R.id.TextViewEmail);
        Password = findViewById(R.id.TextViewPassword);
        button = findViewById(R.id.button2);
        // get value from First activity
        Intent intent  = getIntent();
        String email = intent.getStringExtra("E");
        String password = intent.getStringExtra("P");
// affecter les valeurs au Text View
        Email.setText(email);
        Password.setText(password);
    // Fonction Onclick pour le button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Envoyer le resultat de ce activity
                Intent i = new Intent();
                i.putExtra("result", "hello ");

                setResult(RESULT_OK  , i);
            }
        });
    }
}