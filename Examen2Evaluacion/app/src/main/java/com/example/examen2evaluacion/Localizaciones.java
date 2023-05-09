package com.example.examen2evaluacion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Localizaciones extends AppCompatActivity {
    AlertDialog.Builder builder= new AlertDialog.Builder(this);
    String Granada = "Granada";
    double latitud = 37.18817;
    double longitud = 3.60667;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localizaciones);
        setTitle("Examen Segunda Evaluacion");
        Button boton1 = findViewById(R.id.Boton1);
        Button boton2 = findViewById(R.id.Boton2);
        Button boton3 = findViewById(R.id.Boton3);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu Menu) {
        getMenuInflater().inflate(R.menu.opciones_menu, Menu);
        return true;
    }
    public  void onClickButton1(View view){
        Intent i = new Intent(this,Mapa.class);
        i.putExtra("Longitud",longitud);
        i.putExtra("Latitud",latitud);
        startActivity(i);
    }
}
