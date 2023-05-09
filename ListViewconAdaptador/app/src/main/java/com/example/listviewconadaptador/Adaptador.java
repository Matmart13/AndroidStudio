package com.example.listviewconadaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter {
private ArrayList<Datos> datos;
private int R_layout_IdView;
private Context contexto;

public Adaptador (Context context, int R_layout_IdView,ArrayList<Datos>entradas){
    super(context,R_layout_IdView,entradas);
    this.datos = entradas;
    this.contexto = context;
    this.R_layout_IdView = R_layout_IdView;
}
@Override
    public View getView(int position, View convertView, ViewGroup parent){
    LayoutInflater mostrado = LayoutInflater.from(getContext());
    View elemento = mostrado.inflate(R_layout_IdView,parent,false);
    TextView texto1 = (TextView) elemento.findViewById(R.id.miTexto);
    texto1.setText(datos.get(position).getTexto1());
    TextView texto2 = (TextView) elemento.findViewById(R.id.miTexto1);
    texto2.setText(datos.get(position).getTexto2());
    return elemento;
}
}
