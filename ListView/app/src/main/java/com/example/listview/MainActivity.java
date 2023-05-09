package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listado = (ListView) findViewById(R.id.miLista);

        final String[] elementosLista = new String[]{"Elemento 1", "Elemento 2","Elemento 3", "Elemento 4"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, elementosLista);

        listado.setAdapter(adaptador);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView miTexto = (TextView) findViewById(R.id.miTexto);
                String elemento = (String) parent.getItemAtPosition(position);
                int pos = position +1;
                miTexto.setText("Se ha seleccionado :" + elemento + " de la posicion " + position);
            }
        });

    }
}