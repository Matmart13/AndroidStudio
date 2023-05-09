package com.example.formulariodospantallas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
/*
Archivo:SegundaVentana.java
Descripcion: Contiene el desarrollo de la segunda ventana

   Fecha   / Autor / Version
   24-10-22/ Martin / 1.0 Versión Inicial
   28-10-22/ Martin / 2.0 Version Final
 */
public class SegundaVentana extends AppCompatActivity {
    Button matricula;

@Override
protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.segundaventana);
    super.onCreate(savedInstanceState);

    TextView miTexto = (TextView) findViewById(R.id.NombreCompleto);

    Bundle extra = getIntent().getExtras();
    String x1 = extra.getString("nombrecompleto");
    miTexto.setText(x1);


    Switch convalida = (Switch) findViewById(R.id.Convalida);


    TextView curso = (TextView) findViewById(R.id.curso);

    ToggleButton tooglebutton = (ToggleButton) findViewById(R.id.tooglebutton);
    TextView textolargo = (TextView) findViewById(R.id.textolargo);
    RatingBar estrellas = (RatingBar) findViewById(R.id.estrellas);
    CheckBox condiciones = (CheckBox) findViewById(R.id.condiciones);
    Button matricula = (Button) findViewById(R.id.matricula);
    EditText textogrande = (EditText) findViewById(R.id.TextoGrande);
    primerosegundo(tooglebutton);

    }
    public void primerosegundo(View view) {
        ToggleButton tooglebutton = (ToggleButton) findViewById(R.id.tooglebutton);
        tooglebutton.setText("1º");
        if(tooglebutton.isChecked()){
            tooglebutton.setText("2º");
        }
    }
    public void convalidar(View view ){
    Switch convalida = (Switch) findViewById(R.id.Convalida);
    if (convalida.isChecked()){
        convalida.setText("Si");
    }else{
        convalida.setText("No");
    }

    }
    public void aceptar(View view){
    CheckBox condiciones= (CheckBox) findViewById(R.id.condiciones);
    if(condiciones.isChecked()){
        condiciones.setText("SI");
    }else{
        condiciones.setText("NO");
    }
    }

    public void onButtonclick(View View){
        TextView miTexto = (TextView) findViewById(R.id.NombreCompleto);
        Switch convalida = (Switch) findViewById(R.id.Convalida);
        Button matricula = (Button) findViewById(R.id.matricula);
        ToggleButton tooglebutton = (ToggleButton) findViewById(R.id.tooglebutton);
        RatingBar estrellas = (RatingBar) findViewById(R.id.estrellas);
        CheckBox condiciones = (CheckBox) findViewById(R.id.condiciones);
        convalidar(convalida);
        EditText textogrande = (EditText) findViewById(R.id.TextoGrande);
        Bundle extra = getIntent().getExtras();
        String x1 = extra.getString("todo");

        if (matricula.callOnClick()){
            textogrande.setText(x1 + " " + convalida + " convalida y " + condiciones + " acepta las condiciones y proporciona " + estrellas.getRating() + " estrellas al formulario." );
        }


    }
}
