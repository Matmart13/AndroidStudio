package com.example.a2botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button miBoton1 = (Button) findViewById(R.id.boton1);
        Button miBoton2 = (Button) findViewById(R.id.boton2);
        Button miBoton3 = (Button) findViewById(R.id.boton3);
        miBoton1.setOnClickListener(this::onClick);
        miBoton2.setOnClickListener(this::onClick);
        miBoton3.setOnClickListener(this::onClick);
    }



    public void onClick(View view){
        TextView miTexto = (TextView) findViewById(R.id.texto);
                switch(view.getId()){
                    case R.id.boton1:
                        miTexto.setText("Pulsado el 2");
                        break;
                    case R.id.boton2:
                        miTexto.setText("Pulsado el 1");
                        break;
                    case R.id.boton3:
                        miTexto.setText("Bienvienidos a MiEjemplo1");
                        break;
                    default:
                        break;
                }
    }
}