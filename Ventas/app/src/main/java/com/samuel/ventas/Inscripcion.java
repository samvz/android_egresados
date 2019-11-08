package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

public class Inscripcion extends AppCompatActivity {

    Spinner spegresado1, spconvocatoria1;
    EditText edtpersona1;
    Date edtfecha1;
    Button btninsguardar1, btninscancelar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscripcion);

        btninsguardar1=(Button)findViewById(R.id.btninsguardar1);
        btninscancelar1=(Button)findViewById(R.id.btninscancelar1);


        btninscancelar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btninsguardar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Convocatoria.class);
                startActivity(i);

            }
        });
    }
}
