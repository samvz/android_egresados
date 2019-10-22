package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Persona extends AppCompatActivity {
    Button btnentrar1;
    Spinner spubi, spcar, spdoc;
    EditText edtnombres, edtapellidos, edtdireccion, edttelefono, edtcelular, edtemail, edtsexo, edtfoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);


        btnentrar1=(Button)findViewById(R.id.btnentrar1);
        spubi=(Spinner)findViewById(R.id.spubi);
        spcar=(Spinner)findViewById(R.id.spcar);
        spdoc=(Spinner)findViewById(R.id.spdoc);
        edtnombres=(EditText)findViewById(R.id.edtnombres);
        edtapellidos=(EditText)findViewById(R.id.edtapellidos);
        edtdireccion=(EditText)findViewById(R.id.edtdireccion);
        edttelefono=(EditText)findViewById(R.id.edttelefono);
        edtcelular=(EditText)findViewById(R.id.edtcelular);
        edtemail=(EditText)findViewById(R.id.edtemail);
        edtsexo=(EditText)findViewById(R.id.edtsexo);
        edtfoto=(EditText)findViewById(R.id.edtfoto);


        btnentrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Egresado.class);
                startActivity(i);

            }
        });
    }
}
