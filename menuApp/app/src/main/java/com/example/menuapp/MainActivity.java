package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/*----------------------------------

Archivo: MainActivity.java
Descripcion: LLeva todo el apartado de java de la aplicacion, que es la programacion para ir de una pantalla a otra
             desde las opciones del menu

   Fecha   / Autor / Version
   07-11-22/ Martin / 1.0 Versión Inicial
   09-11-22/ Martin / 1.5 Versión Avanzada
   11-11-22/ MArtin / 2.0 Versión Final
--------------------------------------*/
public class MainActivity extends  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu Menu) {
        getMenuInflater().inflate(R.menu.menu, Menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem Item) {

        switch (Item.getItemId()) {
            case R.id.opcion1:
                setContentView(R.layout.ventana1);
                return true;
            case R.id.opcion2:
                setContentView(R.layout.ventana2);
                return true;

            default:
                return super.onOptionsItemSelected(Item);
        }
    }
}