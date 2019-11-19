package com.samuel.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Persona extends AppCompatActivity {
    Button btnentrar1, btncancelar;
    private Spinner spubi, spcar, spdoc;
    EditText edtnombres, edtapellidos, edtdireccion, edttelefono, edtcelular, edtemail, edtsexo, edtfoto;
    private String BASE_URL_API = "http://192.168.0.127/android_egresados/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);

        btncancelar = (Button) findViewById(R.id.btncancelar);
        btnentrar1 = (Button) findViewById(R.id.btnentrar1);
        spubi = (Spinner) findViewById(R.id.spubi);
        spcar = (Spinner) findViewById(R.id.spcar);
        spdoc = (Spinner) findViewById(R.id.spdoc);
        edtnombres = (EditText) findViewById(R.id.edtnombres);
        edtapellidos = (EditText) findViewById(R.id.edtapellidos);
        edtdireccion = (EditText) findViewById(R.id.edtdireccion);
        edttelefono = (EditText) findViewById(R.id.edttelefono);
        edtcelular = (EditText) findViewById(R.id.edtcelular);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtsexo = (EditText) findViewById(R.id.edtsexo);
        edtfoto = (EditText) findViewById(R.id.edtfoto);

        loadTypeDocuments();

        spdoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int post, long l) {
                System.out.println("selected: " + adapterView.getItemAtPosition(post));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnentrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Egresado.class);
                startActivity(i);

            }
        });
    }

    public void loadTypeDocuments() {
        String URL = BASE_URL_API + "tipodocumento/mostrar.php";


        Ion.with(getApplicationContext())
                .load(URL)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {

                        try {
                            ArrayList<String> documents = new ArrayList<String>();

                            JSONArray jsonArray = new JSONArray(result.toString());
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json = jsonArray.getJSONObject(i);
                                documents.add(json.getString("nombre"));
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, documents);
                            spdoc.setAdapter(adapter);

                        } catch (JSONException err) {

                        }
                    }
                });
    }
}
