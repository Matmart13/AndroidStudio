package com.example.exame2eval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Thread mensaje;
    int bucle= 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView miTextoCambiante= findViewById(R.id.miTexto);

        mensaje = new Thread(new Runnable() {
            @Override
            public void run() {
                while(bucle==1){
                    String txt= "ESTA APP HA SIDO CREADA POR:";
                    miTextoCambiante.setText(txt);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    txt="Martin Mancini";
                    miTextoCambiante.setText(txt);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    txt="Él día 10 de abril de 2023";
                    miTextoCambiante.setText(txt);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    txt="Para el examen de la segunda evaluación";
                    miTextoCambiante.setText(txt);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        mensaje.start();
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