package com.samuel.ventas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorUsuarios extends BaseAdapter {

    private Context ctx;
    private List<Usuarios> lista;

    public AdaptadorUsuarios(Context ctx2, List<Usuarios> lista2){

        ctx = ctx2;
        lista = lista2;

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Usuarios getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = null;

        if(convertView==null){
            LayoutInflater inflater = ((Activity)ctx).getLayoutInflater();
            v = inflater.inflate(R.layout.lista_usuarios, null);

        }
        else{
            v = convertView;
        }

        Usuarios c = getItem(position);
        TextView txtid = (TextView)v.findViewById(R.id.txtid);
        TextView txtusuario = (TextView)v.findViewById(R.id.txtusuario);
        TextView txtpassword = (TextView)v.findViewById(R.id.txtpassword);
        TextView txtnombres = (TextView)v.findViewById(R.id.txtnombres);
        TextView txtestado = (TextView)v.findViewById(R.id.txtestado);

        txtid.setText(c.getId());
        txtusuario.setText(c.getUsuario());
        txtpassword.setText(c.getPassword());
        txtnombres.setText(c.getNombres());
        txtestado.setText(c.getEstado());

        return v;


    }
}
