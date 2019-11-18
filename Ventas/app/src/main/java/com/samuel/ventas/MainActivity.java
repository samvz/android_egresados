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

public class MainActivity extends AppCompatActivity {

    Button btnacceder, btnsalir, btnregistrarse;
    EditText edtusuario, edtpassword;
    private String BASE_URL_API = "http://192.168.0.127/android_egresados/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusuario = (EditText) findViewById(R.id.edtusuario);
        edtpassword = (EditText) findViewById(R.id.edtpassword);
        btnregistrarse = (Button) findViewById(R.id.btnregistrarse);

        btnacceder=(Button)findViewById(R.id.btnacceder);
        btnsalir=(Button)findViewById(R.id.btnsalir);

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Principal.class);
                startActivity(i);

            }
        });

        btnacceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = edtusuario.getText().toString();
                String password = edtpassword.getText().toString();
                String Login = BASE_URL_API + "/ingresar.php";
                if(usuario.isEmpty()){
                    edtusuario.setError("Debe ingresar el usuario");
                }
                else{
                    if(password.isEmpty()){
                        edtpassword.setError("Debe ingresar el password");
                    }
                    else{
                        Ion.with(getApplicationContext())
                                .load(Login)
                                .setBodyParameter("usuario", usuario)
                                .setBodyParameter("password", password)
                                .asJsonObject()
                                .setCallback(new FutureCallback<JsonObject>() {
                                    @Override
                                    public void onCompleted(Exception e, JsonObject result) {
                                        if(result.get("LOGIN").getAsString().equals("OK")){
                                            Intent i = new Intent(getApplicationContext(),Menu.class);
                                            startActivity(i);
                                        }
                                        else{
                                           Toast.makeText(getApplicationContext(),"usuario no existe", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                    }
                }

            }
        });
    }
}
