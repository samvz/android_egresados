package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Principal extends AppCompatActivity {
    Button btncerrar, btnnuevo, btnguardar;
    EditText edtuser, edtpass, edtnombres;
    private String URL = "http://192.168.137.12/egresados";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btncerrar=(Button)findViewById(R.id.btncerrar);
        btnnuevo=(Button)findViewById(R.id.btnnuevo);
        btnguardar=(Button)findViewById(R.id.btnguardar);
        edtuser=(EditText)findViewById(R.id.edtuser);
        edtpass=(EditText)findViewById(R.id.edtpass);
        edtnombres=(EditText)findViewById(R.id.edtnombres);

        btncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiar();
            }
        });

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = edtuser.getText().toString();
                String password = edtpass.getText().toString();
                String nombres = edtnombres.getText().toString();

                String crear = URL+"/usuarios/crear.php";

                if(usuario.isEmpty()){
                    edtuser.setError("Campo Obligatorio");
                }
                else{
                    if(password.isEmpty()){
                        edtpass.setError("Campo OBligatirio");
                    }
                    else{
                        if(nombres.isEmpty()){
                            edtnombres.setError("Campo Obligatorio");
                        }
                        else{
                            //CREATE
                            Ion.with(getApplicationContext())
                                    .load(crear)
                                    .setBodyParameter("usuario",usuario)
                                    .setBodyParameter("password",password)
                                    .setBodyParameter("nombres",nombres)
                                    .asJsonObject()
                                    .setCallback(new FutureCallback<JsonObject>() {
                                        @Override
                                        public void onCompleted(Exception e, JsonObject result) {
                                            System.out.println("result:"+result);
                                            if(result.get("CREATE").getAsString().equals("OK")){
                                                Toast.makeText(getApplicationContext(),"DAtos guardados exitosamente",Toast.LENGTH_LONG).show();
                                            }
                                            else{
                                                Toast.makeText(getApplicationContext(),"Hubo un error al guardar los datos",Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });

                        }
                    }
                }

            }
        });
    }
    public void limpiar(){
        edtuser.setText("");
        edtpass.setText("");
        edtnombres.setText("");
        edtuser.requestFocus();
    }
}
