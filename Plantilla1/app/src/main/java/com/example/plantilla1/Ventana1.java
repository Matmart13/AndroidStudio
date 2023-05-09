package com.example.plantilla1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Ventana1 extends AppCompatActivity {
    private TextView mitexto;
    private TextView Latitud;
    private TextView Longitud;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventanta1);
        mitexto = (TextView)findViewById(R.id.mitexto) ;
        String dato = getIntent().getStringExtra("texto");
        mitexto.setText("Hola : " +dato);
        Latitud = (TextView) findViewById(R.id.Latitud);
        Longitud = (TextView) findViewById(R.id.Longitud);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu Menu) {
        getMenuInflater().inflate(R.menu.opcionesmenu1, Menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem Item) {

        switch (Item.getItemId()) {
            case R.id.opcion1:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.opcion3:
                Intent j = new Intent(this, Ventana2.class);
                j.putExtra("Longitud",Double.parseDouble(Longitud.getText().toString()));
                j.putExtra("Latitud",Double.parseDouble(Latitud.getText().toString()));
                startActivity(j);
                return true;
        }
        return super.onOptionsItemSelected(Item);
    }
}

