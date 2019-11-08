package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import static com.samuel.ventas.R.id.btnimgentrar4;

public class Menu extends AppCompatActivity {
     ImageButton btnimgentrar1, btnimgentrar2, btnimgentrar3, btnimgentrar4;
     Button btncerrarsession;
    private final String URL = "http://172.24.6.39/bdventas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        btnimgentrar1=(ImageButton) findViewById(R.id.btnimgentrar1);
        btnimgentrar2=(ImageButton)findViewById(R.id.btnimgentrar2);
        btncerrarsession=(Button)findViewById(R.id.btncerrarsesion);
        btnimgentrar3=(ImageButton)findViewById(R.id.btnimgentrar3);
        btnimgentrar4=(ImageButton)findViewById(R.id.btnimgentrar4);


        btnimgentrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Inscripcion.class);
                startActivity(i);

            }
        });

        btnimgentrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Empleado.class);
                startActivity(i);

            }
        });
        btnimgentrar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Persona.class);
                startActivity(i);

            }
        });
        btnimgentrar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Cargo.class);
                startActivity(i);

            }
        });

        btncerrarsession.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String cerrar = URL +"/cerrar.php";
                Ion.with(getApplicationContext())
                        .load(cerrar)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                if(result.get("LOGIN").getAsString().equals("CLOSE")){
                                    finish();
                                }
                            }
                        });


            }
        });
    }
}
