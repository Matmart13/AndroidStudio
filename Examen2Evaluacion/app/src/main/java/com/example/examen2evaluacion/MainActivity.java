package com.example.examen2evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String linea ;
    String[] Ciudad = new String[3];
    String nombre = "Martin";
    String App = "Esta app ha sido creada por";
    String Fecha = "El dia 10 de abril de 2023";
    String examen = "Para el examen de la segunda evaluacion";
    String inicio[] = new String[4];
    Thread miPublicidad;
    TextView miTexto ;
    String nombreAlumno;
    String curso;
    String notas;
    String fecha;
    String hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Examen Segunda Evaluacion");
        inicio[0] = App;
        inicio[1] = nombre;
        inicio[2] = Fecha;
        inicio[3] = examen;
        miTexto = (TextView) findViewById(R.id.Texto);
        nombreAlumno = getIntent().getStringExtra("Nombre");
        curso = getIntent().getStringExtra("Curso");
        notas = getIntent().getStringExtra("Nota");
        fecha = getIntent().getStringExtra("Fecha");
        hora = getIntent().getStringExtra("Hora");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu Menu) {
        getMenuInflater().inflate(R.menu.opciones_menu, Menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem Item) {

        switch (Item.getItemId()) {
            case R.id.opcion2:
                Intent i = new Intent(this, Localizaciones.class);
                startActivity(i);
                return true;
            case R.id.opcion3:
                Intent form = new Intent(this, Formulario.class);
                startActivity(form);

                return true;
            case R.id.opcion4:
                Intent resultado = new Intent(this, resultados.class);
                resultado.putExtra("Nombre",nombre);
                resultado.putExtra("Curso",curso);
                resultado.putExtra("Fecha",fecha);
                resultado.putExtra("Hora",hora);
                resultado.putExtra("Nota",notas);
                startActivity(resultado);
                return true;
            case R.id.opcion5:
                Intent  about = new Intent(this, about.class);
                about.putExtra("Nombre", nombre);
                startActivity(about);
                return true;

        }
        return super.onOptionsItemSelected(Item);
    }
    public void onStart(){
        super.onStart();
         miPublicidad = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < inicio.length; i++) {
                    cambiaTexto(inicio[i]);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    public  void cambiaTexto(String texto){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                miTexto.setText(texto);
            }
        });
    }
}