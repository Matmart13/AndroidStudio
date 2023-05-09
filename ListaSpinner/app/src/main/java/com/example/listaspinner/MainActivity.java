package com.example.listaspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner listado = (Spinner) findViewById(R.id.Spinner);
        final String[] elementosLista = new String[]{"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, elementosLista);
        listado.setAdapter(adaptador);
        listado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private AdapterView<?> parent;
            TextView miTexto = (TextView) findViewById(R.id.miTexto);

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) parent.getItemAtPosition(position);
                miTexto.setText("Seleccionado : " + elemento);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                miTexto.setText("Nada Seleccionado");
            }
        });


    }
}