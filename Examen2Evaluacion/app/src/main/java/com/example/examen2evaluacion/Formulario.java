package com.example.examen2evaluacion;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Formulario extends AppCompatActivity {
    Button boton ;
    TextView nombre;
    TextView curso;
    TextView fexamen;
    TextView hexamen;
    RadioGroup nota;
    String notas;
    RadioButton suspenso;
    RadioButton cinco ;
    RadioButton notable;
    RadioButton sobresaliente;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        boton = (Button) findViewById(R.id.button);
        nombre = (TextView) findViewById(R.id.Nombre);
        curso = (TextView) findViewById(R.id.Curso);
        fexamen = (TextView) findViewById(R.id.Fecha);
        hexamen = (TextView)findViewById(R.id.Hora);
        nota = (RadioGroup) findViewById(R.id.Nota);
        suspenso = (RadioButton) findViewById(R.id.Suspender);
        cinco = (RadioButton) findViewById(R.id.cinco);
        notable = (RadioButton) findViewById(R.id.notable);
        sobresaliente = (RadioButton) findViewById(R.id.sobresaliente);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.Suspender:
                if (checked)
                    notas =suspenso.getText().toString();
                    break;
            case R.id.cinco:
                if (checked)
                    notas = cinco.getText().toString();
                    break;
            case R.id.notable:
                if (checked)
                    notas = notable.getText().toString();
                    break;
            case R.id.sobresaliente:
                if (checked)
                    notas = sobresaliente.getText().toString();
                    break;
        }
    }
    public void OnclickFecha(View view){
        final Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH);
        int day = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog fecha= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(Formulario.this, "SELECCIONADO "+dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_SHORT).show();
                fexamen.setText(dayOfMonth + "/" + month+"/"+year);
            }
        },year,month,day);
        fecha.show();

    }
    public void Onclickhora(View view){
        final Calendar reloj= Calendar.getInstance();
        int hora= reloj.get(Calendar.HOUR);
        int min= reloj.get(Calendar.MINUTE);

        TimePickerDialog horaD= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(Formulario.this, "La hora es "+ hora+":"+min, Toast.LENGTH_SHORT).show();
                hexamen.setText(hourOfDay + ":" + minute);
            }
        },hora,min,false);
        horaD.show();

    }
    public void Onclickbutton(View view){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("Nombre",nombre.getText().toString());
        i.putExtra("Curso",curso.getText().toString());
        i.putExtra("Fecha",fexamen.getText().toString());
        i.putExtra("Hora",hexamen.getText().toString());
        i.putExtra("Nota",notas);
        startActivity(i);
    }
    public void OnclickImagen(View view){
        Intent i = new Intent(this,Camara.class);
        startActivity(i);
    }

}
