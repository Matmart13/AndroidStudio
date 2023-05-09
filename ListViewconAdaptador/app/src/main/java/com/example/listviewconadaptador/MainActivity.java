package com.example.listviewconadaptador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Datos> datos = new ArrayList<>();
        datos.add(new Datos("Linea Superior 1","Linea Inferior 1"));
        datos.add(new Datos("Linea Superior 2", "Linea Inferior 2"));
        datos.add(new Datos("Linea Superior 3","Linea inferior 3"));

        ListView listado = (ListView) findViewById(R.id.miLista);
        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera,null);

        Adaptador miAdaptador = new Adaptador(this,R.layout.elementos,datos);
        listado.setAdapter(miAdaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adaptador, View view, int position, long id) {
                if(id>= 0){
                    String elemento = ((Datos)adaptador.getItemAtPosition(position)).getTexto1();
                    TextView miTexto = (TextView) findViewById(R.id.miTexto);
                    miTexto.setText("Se ha seleccionado " + elemento + " de la posición " + position);
                }
            }
        });
    }
}