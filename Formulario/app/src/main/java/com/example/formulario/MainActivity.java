package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox miCheckBox = (CheckBox) findViewById(R.id.miCheckbox);
        clickEnCheckBox(miCheckBox);
        Spinner miSpinner = (Spinner)findViewById(R.id.miSpinner);
        Spinner(miSpinner);
        Switch interruptor = (Switch) findViewById(R.id.miSwitch);
        interruptor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView mitexto = (TextView) findViewById(R.id.miEditText);
                TextView mitexto2 = (TextView) findViewById(R.id.miEditText1);
                TextView mitexto3 = (TextView) findViewById(R.id.Nombre);
                if (isChecked){
                    mitexto.setText(" ");
                    mitexto2.setText(" ");
                    mitexto3.setText(" ");
                }else{

                }

            }
        });
        SeekBar miSeekbar = (SeekBar) findViewById(R.id.miSeekbar);
        miSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            TextView mitexto = (TextView) findViewById(R.id.miTexto);
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            mitexto.setText("Seek bar a cambiado a "+ i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mitexto.setText("Seekbar Sart tracking");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mitexto.setText("Seekbar Stop Tracking");
            }
        });
        miSeekbar.getProgress();
        RatingBar miRatingBar = (RatingBar) findViewById(R.id.miRatingBar);
        miRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                SeekBar miSeekbar = (SeekBar) findViewById(R.id.miSeekbar);
                miSeekbar.setProgress(miRatingBar.getProgress() *10);
            }
        });
        miRatingBar.getNumStars();
        miRatingBar.getRating();

    }

    public void clickEnImagenBoton1(View view){
        TextView mitexto = (TextView) findViewById(R.id.Textview1);
        TextView mitexto2 = (TextView) findViewById(R.id.textview);
        EditText miEdiText = (EditText) findViewById(R.id.miEditText1);
        TextView mitexto1 = (TextView) findViewById(R.id.Textview);
        EditText miEdiText1= (EditText) findViewById(R.id.miEditText);
        TextView nombre = (TextView) findViewById(R.id.Nombre);
        Spinner miSpinner = (Spinner)findViewById(R.id.miSpinner);
        String cadenaTexto = miEdiText.getText().toString() + " " + miEdiText1.getText().toString() + " su nota es:" +miSpinner.getSelectedItem().toString()  ;
        nombre.setText(cadenaTexto);
    }
    public void Spinner (View view){
        Spinner miSpinner = (Spinner)findViewById(R.id.miSpinner);
        String[] valores = {"1","2","3","4","5","6","7","8","9","10"};
        miSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));

    }
    public  void clickEnCheckBox(View view){
        TextView mitexto = (TextView) findViewById(R.id.miCheckbox);
        boolean pulsado = ((CheckBox)view).isChecked();
        if(pulsado){
            mitexto.setText("CheckBoxOn");
        }else{
            mitexto.setText("Checkbox OFF");
        }
    }
}