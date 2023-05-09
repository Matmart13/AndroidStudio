package com.example.exame2eval;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        String mensaje= "Esta app ha sido creada por Martin Mancini, el dia " +
                " 17 de febrero de 2023, version 2.0";
        TextView miTextView= findViewById(R.id.miTexto);
        miTextView.setText(mensaje);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion1:
                Intent pantalla1 = new Intent(this, MainActivity.class);
                startActivity(pantalla1);
                return true;
            case R.id.opcion2:

                Intent pantalla2= new Intent(this, Aprobacion.class);
                startActivity(pantalla2);
                return true;
            case R.id.opcion3:
                Intent pantalla3 = new Intent(this, Formulario.class);
                startActivity(pantalla3);
                return true;
            case R.id.opcion4:
                Intent pantalla4 = new Intent(this, PantallaResultados.class);
                startActivity(pantalla4);
                return true;
            case R.id.opcion5:
                Intent pantalla5 = new Intent(this, About.class);
                startActivity(pantalla5);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
