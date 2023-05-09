package com.example.exame2eval;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Formulario extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);

        ActivityResultLauncher activityResultLauncher;

        EditText horaTxt= findViewById(R.id.Hora);
        EditText fechaTxt= findViewById(R.id.Fecha);
        EditText nombre= findViewById(R.id.nombre);
        EditText curso= findViewById(R.id.curso);
        ImageView imagen= findViewById(R.id.foto);



                activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            //Aqui es donde tenemos la Imagen capturada
                            Bundle bundle = result.getData().getExtras();
                            Bitmap bitmap = (Bitmap) bundle.get("data");
                            imagen.setImageBitmap(bitmap);
                        }
                    }
                });

;
        final Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH);
        int day = calendario.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog fecha= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int yearv, int monthv, int dayOfMonth) {
                monthv = month+1;
                fechaTxt.setText(dayOfMonth+"/"+monthv +"/"+yearv);
            }
          },year,month,day);

        final Calendar reloj= Calendar.getInstance();
        int hora= reloj.get(Calendar.HOUR);
        int min= reloj.get(Calendar.MINUTE);
        TimePickerDialog horaD= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                horaTxt.setText(hourOfDay+":"+minute);
            }
        },hora,min,false);

        horaTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horaD.show();
            }
        });
        fechaTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fecha.show();
            }
        });
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("¿Seguro que quieres cambiar tu avatar?").setTitle("CAMBIAR AVATAR").setIcon(R.mipmap.ic_launcher).
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                activityResultLauncher.launch(intent);
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Formulario.this, "HAS PULSADO NO", Toast.LENGTH_SHORT).show();
                            }
                        }).setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                            }
                        });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
        });




    }
    public void Guarder(View view){
        Message messageBundle = new Message();
        Bundle miBundle = new Bundle();
        String todo = "";

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.miRadioButtonGroup);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
        String textRadio=(String) radioButton.getText();

        EditText miEditText = (EditText) findViewById(R.id.nombre);

        String x = miEditText.getText().toString();

        EditText miEditText2 = (EditText) findViewById(R.id.curso);
        String x1 = miEditText2.getText().toString();

        EditText miEditText3 = (EditText) findViewById(R.id.Fecha);
        String x2 = miEditText3.getText().toString();

        EditText miEditText4 = (EditText) findViewById(R.id.Hora);
        String x3 = miEditText4.getText().toString();

        PantallaResultados panatella = new PantallaResultados();
        PantallaResultados.MiHandler handler = panatella.new MiHandler();
        todo= x + " en el curso " + x1+ " el dia "+x2+" a las "+x3;
        String Y ="Considera que se merece "+textRadio;

        miBundle.putString("CLAVE1", todo);
        miBundle.putString("CLAVE2",Y);
        messageBundle.setData(miBundle);
        handler.sendMessage(messageBundle);
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
