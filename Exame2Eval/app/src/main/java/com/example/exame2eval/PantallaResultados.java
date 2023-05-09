package com.example.exame2eval;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaResultados extends AppCompatActivity {
    TextView nombre;
    TextView result1;
    TextView result2;
    String nombre1;
    static String resultado;
    static String resultado2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

         nombre= findViewById(R.id.nombreTxt);
         result1= findViewById(R.id.primertxt);
         result2= findViewById(R.id.seguntxt);
         nombre.setText(nombre1);
         result1.setText(resultado2);
         result2.setText(resultado);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion1:
                Intent Inicio = new Intent(this, MainActivity.class);
                startActivity(Inicio);
                return true;
            case R.id.opcion2:

                Intent Mapa= new Intent(this, Aprobacion.class);
                startActivity(Mapa);
                return true;
            case R.id.opcion3:
                Intent Formulario = new Intent(this, Formulario.class);
                startActivity(Formulario);
                return true;
            case R.id.opcion4:
                Intent PantallaResultados = new Intent(this, PantallaResultados.class);
                startActivity(PantallaResultados);
                return true;
            case R.id.opcion5:
                Intent about = new Intent(this, About.class);
                startActivity(about);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    class MiHandler extends Handler{
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            Bundle miBundle ;
            miBundle = msg.getData();

            resultado = miBundle.getString("CLAVE1");
            resultado2 = miBundle.getString("CLAVE2");
        }
    }

}
