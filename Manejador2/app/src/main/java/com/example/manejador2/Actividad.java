package com.example.manejador2;

import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Actividad extends AppCompatActivity {
public static TextView miTexto;
public Handler handler2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad);
        miTexto = (TextView) findViewById(R.id.textoActividad2);
        miTexto.setText("Actividad 2 en marcha");
    }
    class MiHandler extends android.os.Handler  {
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            Bundle miBundle = msg.getData();
            miTexto.setText(""+miBundle.get("Clave3"));
        }
    }
}

