package com.example.examen2evaluacion;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resultados extends AppCompatActivity {
    String nombre;
    String curso;
    String nota ;
    String fecha;
    String hora;
    TextView texto;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        nombre = getIntent().getStringExtra("Nombre");
        curso = getIntent().getStringExtra("Curso");
        nota= getIntent().getStringExtra("Nota");
        fecha = getIntent().getStringExtra("Fecha");
        hora = getIntent().getStringExtra("Hora");
        texto = findViewById(R.id.textView);
        texto.setText(nombre + " hace el examen del curso: " + curso + " el dia " + fecha + "a las " + hora + " con una nota de : " + nota);

    }
}
