package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Egresado extends AppCompatActivity {
    Button btnentrar2, btncargocerrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egresado);

        btnentrar2=(Button)findViewById(R.id.btnentrar2);
        btncargocerrar=(Button)findViewById(R.id.btncargocerrar);


        btncargocerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnentrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Principal.class);
                startActivity(i);

            }
        });
    }
}
