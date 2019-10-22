package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.samuel.ventas.R.id.btnimagen4;

public class Menu extends AppCompatActivity {
     ImageButton btnimgentrar1, btnimagen4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnimgentrar1=(ImageButton) findViewById(R.id.btnimgentrar1);
        btnimagen4=(ImageButton)findViewById(R.id.btnimagen4);

        btnimgentrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Persona.class);
                startActivity(i);

            }
        });

        btnimagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Cargo.class);
                startActivity(i);

            }
        });
    }
}
