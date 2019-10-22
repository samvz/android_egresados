package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Convocatoria extends AppCompatActivity {
    Button btnentrar4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convocatoria);

        btnentrar4=(Button)findViewById(R.id.btnentrar4);

        btnentrar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Menu.class);
                startActivity(i);

            }
        });
    }
}
