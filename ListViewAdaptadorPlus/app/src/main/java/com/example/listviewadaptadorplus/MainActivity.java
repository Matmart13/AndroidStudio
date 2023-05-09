package com.example.listviewadaptadorplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/*
Archivo:MainActivity.java
Descripcion: Se añaden los datos que hay que añadir a la lista y que se ejecute el programa.

   Fecha   / Autor / Version
   24-10-22/ Martin / 1.0 Versión Inicial
   28-10-22 / Martin / 2.0 Versión Final
 */
public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private TextView texto;
    private RadioButton radioButton_pulsado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);

        ArrayList<lista_entrada> datos = new ArrayList<>();
        datos.add(new lista_entrada(R.drawable.ima1, "Donuts", "2dasjkdlas"));
        datos.add(new lista_entrada(R.drawable.ima2, "Froyo", "2dasjkdlas"));
        datos.add(new lista_entrada(R.drawable.ima3, "GingerBread", "2dasjkdlas"));
        datos.add(new lista_entrada(R.drawable.ima4, "HoneyComb", "2dasjkdlas"));
        datos.add(new lista_entrada(R.drawable.ima5, "Ice Cream", "2dasjkdlas"));
        datos.add(new lista_entrada(R.drawable.ima6, "Jelly Bean", "2dasjkdlas"));
        datos.add(new lista_entrada(R.drawable.ima7, "Kit Kat", "2dasjkdlas"));
        datos.add(new lista_entrada(R.drawable.ima8, "LOLLIPOP", "2dasjkdlas"));

        lista = (ListView) findViewById(R.id.Listview_listado);
        lista.setAdapter(
                new lista_adaptador(this, R.layout.activity_main, datos) {
                    @Override
                    protected void onEntrada(Object entrada, View view) {
                        if (datos != null) {
                            TextView texto_superior_entada = (TextView) view.findViewById(R.id.texto_titulo);
                            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.texto_datos);
                            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imagen);

                            String txtSup = ((lista_entrada) entrada).get_textoTitulo();
                            String txtInf = ((lista_entrada) entrada).get_textoContenido();
                            int idImagen = ((lista_entrada) entrada).get_idImagen();
                            texto_superior_entada.setText(txtSup);
                            texto_inferior_entrada.setText(txtInf);
                            imagen_entrada.setImageResource(idImagen);
                        }
                    }

                    @Override
                    protected void onEntrada(lista_entrada datos, View view) {

                    }
                }

        );

    }

}