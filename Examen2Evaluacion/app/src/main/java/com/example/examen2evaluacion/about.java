package com.example.examen2evaluacion;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class about extends AppCompatActivity {
    TextView mitexto;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        setTitle("Examen Segunda Evaluacion");
        mitexto = (TextView)findViewById(R.id.Texto);
        String nombre =getIntent().getStringExtra("Nombre");
        mitexto.setText("Este examen ha sido realizado por: " + nombre);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu Menu) {
        getMenuInflater().inflate(R.menu.opciones_menu, Menu);
        return true;
    }

}
