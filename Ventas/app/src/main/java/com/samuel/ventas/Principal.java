package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {
    Button btncerrar, btnnuevo, btnguardar, btncerrarusuarios;
    EditText edtuser, edtpass, edtnombres;
    ListView lsusuarios;
    private String URL = "http://172.24.6.39/bdventas";
    AdaptadorUsuarios adaptadorUsuarios;
    List<Usuarios> lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
       // btncerrar=(Button)findViewById(R.id.btncerrar);
        btnnuevo=(Button)findViewById(R.id.btnnuevo);
        btnguardar=(Button)findViewById(R.id.btnguardar);
        edtuser=(EditText)findViewById(R.id.edtuser);
        edtpass=(EditText)findViewById(R.id.edtpass);
        edtnombres=(EditText)findViewById(R.id.edtnombres);
        btncerrarusuarios=(Button)findViewById(R.id.btncerrarusuarios);

       /* lsusuarios=(ListView)findViewById(R.id.lsusuarios);

        lista = new ArrayList<Usuarios>();
        adaptadorUsuarios = new AdaptadorUsuarios(getApplicationContext(),lista);
        lsusuarios.setAdapter(adaptadorUsuarios);
        listausuarios();*/



       btncerrarusuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        /*Intent intent = new Intent(getApplicationContext(), Principal.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);*/

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

    /*public void listausuarios(){

        String listar = URL +"/usuarios/mostrar.php";
        Ion.with(getBaseContext())
                .load(listar)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for(int i=0; i<result.size();i++){

                            JsonObject obj = result.get(i).getAsJsonObject();
                            Usuarios c = new Usuarios();
                            c.setId(obj.get("id").getAsInt());
                            c.setUsuario(obj.get("usuario").getAsString());
                            c.setPassword(obj.get("password").getAsString());
                            c.setNombres(obj.get("nombres").getAsString());
                            c.setEstado(obj.get("estado").getAsInt());

                            lista.add(c);

                        }
                        adaptadorUsuarios.notifyDataSetChanged();
                    }
                });
    }*/
}
