package com.example.pruebahandlerehilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView miTexto;
    static String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        miTexto = (TextView) findViewById(R.id.textViewTexto);
        miTexto.setText(nombre);
    }


    class MiHandler extends Handler {

        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            Bundle miBundle = msg.getData();
            nombre =("" + miBundle.get("CLAVE1"));
        }

    }
}