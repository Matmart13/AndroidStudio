package com.example.formulariodospantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
/*
Archivo: MainActivity.java
Descripcion: Contiene el desarrollo de la primera ventana.

   Fecha   / Autor / Version
   24-10-22/ Martin / 1.0 Versión Inicial
   28-10-22/ Martin / 2.0 Version Final
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView cabecera = (TextView)findViewById(R.id.Cabecera);
        TextView nombre = (TextView)findViewById(R.id.nombre);
        TextView apellidos = (TextView)findViewById(R.id.apellido);
        TextView tipocurso = (TextView)findViewById(R.id.TextoCurso);
        EditText nombre1 = (EditText)findViewById(R.id.edittext1);
        EditText apellidos1 = (EditText)findViewById(R.id.edittext2);
        RadioGroup gruporadio = (RadioGroup)findViewById(R.id.botones);
        RadioButton boton1 = (RadioButton)findViewById(R.id.hombre);
        RadioButton boton2 = (RadioButton)findViewById(R.id.mujer);
        RadioButton boton3 = (RadioButton)findViewById(R.id.otro);
        Spinner miSpinner = (Spinner)findViewById(R.id.Spinner);
        Spinner(miSpinner);
        onRadioButtonClicked(boton1);

        ImageButton imageButton = (ImageButton) findViewById(R.id.ImageButton);

    }
    public void Spinner (View view){
        Spinner miSpinner = (Spinner)findViewById(R.id.Spinner);
        String[] valores = {"SMR","TECO","DAM","TAFAD","FARMACIA","INFANTIL"};
        miSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.hombre:
                if (checked)
                    break;
            case R.id.mujer:
                if (checked)

                    break;
            case R.id.otro:
                if (checked)
                    break;
        }
    }
    public void Cambiarpantalla(View view) {
        EditText nombre1 = (EditText)findViewById(R.id.edittext1);
        EditText apellidos1 = (EditText)findViewById(R.id.edittext2);
        Spinner miSpinner = (Spinner)findViewById(R.id.Spinner);
        Spinner(miSpinner);
        RadioGroup gruporadio = (RadioGroup)findViewById(R.id.botones);
        RadioButton boton1 = (RadioButton)findViewById(R.id.hombre);
        onRadioButtonClicked(boton1);
        int radioButtonID = gruporadio.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) gruporadio.findViewById(radioButtonID);
        String textoRadio=(String) radioButton.getText();

        String curso = miSpinner.getSelectedItem().toString();
        Intent i = new Intent(this, SegundaVentana.class);
        String nombrecompleto = nombre1.getText() + " "+ apellidos1.getText() ;
        i.putExtra("nombrecompleto",nombrecompleto);
        startActivity(i);
        String todo = nombrecompleto + " "+ textoRadio + " " + curso ;
        i.putExtra("todo", todo);

    }
}