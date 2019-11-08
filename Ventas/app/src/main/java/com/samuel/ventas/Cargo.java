package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Cargo extends AppCompatActivity {
    Button btnnombrecargo, btncancelar1;
    EditText edtnombrecargo;
    private String URL = "http://192.168.43.95/egresados";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo);

        edtnombrecargo = (EditText)findViewById(R.id.edtnombrecargo);
        btnnombrecargo=(Button)findViewById(R.id.btnnombrecargo);
        btncancelar1 =(Button)findViewById(R.id.btncancelar1);

        btncancelar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnnombrecargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtnombrecargo.getText().toString();

                System.out.println("nombr:"+nombre);
                String crear = URL + "/usuarios/cargo.php";

                if (nombre.isEmpty()) {
                    edtnombrecargo.setError("Campo Obligatorio");
                } else {
                    //CREATE
                    Ion.with(getApplicationContext())
                            .load(crear)
                            .setBodyParameter("nombre", nombre)

                            .asJsonObject()
                            .setCallback(new FutureCallback<JsonObject>() {
                                @Override
                                public void onCompleted(Exception e, JsonObject result) {
                                    System.out.println("result:" + result);
                                    if (result.get("CREATE").getAsString().equals("OK")) {
                                        Toast.makeText(getApplicationContext(), "DAtos guardados exitosamente", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Hubo un error al guardar los datos", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }
            }
        });
    }

    public void limpiar() {
        edtnombrecargo.setText("");

    }
}
