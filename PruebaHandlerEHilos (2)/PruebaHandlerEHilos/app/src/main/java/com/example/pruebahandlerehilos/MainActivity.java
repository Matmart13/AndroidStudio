package com.example.pruebahandlerehilos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Handler handler;
    Button botonGuardar;
    Button botonP2;
    Thread textoQueCambia;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonGuardar = (Button) findViewById(R.id.botonGuardar);
        botonGuardar.setOnClickListener(this);

        botonP2 = (Button) findViewById(R.id.botonPantalla2);
        botonP2.setOnClickListener(this);

        texto = (TextView) findViewById(R.id.texto);


        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Bundle miBundle = msg.getData();
            }
        };


    }

    @Override
    public void onClick(View view) {
        Message mensajeBundle = new Message();
        Bundle miBundle = new Bundle();
        switch (view.getId()){

            case R.id.botonGuardar:
                MainActivity2 mainActivity2 = new MainActivity2();
                MainActivity2.MiHandler handlerPantalla2 = mainActivity2.new MiHandler();

                miBundle.putString("CLAVE1", "HOla");
                miBundle.putString("CLAVE2", "Que tal");
                miBundle.putString("CLAVE3", "Adios");
                mensajeBundle.setData(miBundle);
                handlerPantalla2.sendMessage(mensajeBundle);
                break;

            case R.id.botonPantalla2:
                Intent cambiaPantalla2 = new Intent(this, MainActivity2.class);
                startActivity(cambiaPantalla2);
                break;

        }
    }




    @Override
    public void onStart(){
        super.onStart();

        //Creamos el hilo que mostrará la publicidad

        textoQueCambia = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 1000;
                while (num>0){
                    for (int i =0; i < 4; i++){
                        cambiaTexto(i);

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num--;
                }
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        textoQueCambia.start();
    }

    //Método que cambia un texto sin ser el propietario del mismo
    public void cambiaTexto(int numText){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (numText == 0){
                    texto.setText("Texto 0");
                }else if (numText == 1){
                    texto.setText("Texto 1");
                }else if (numText == 2){
                    texto.setText("Texto 2");
                }else if (numText == 3){
                    texto.setText("Texto 3");
                }
            }
        });
    }


}