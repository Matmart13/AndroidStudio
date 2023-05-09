package com.example.a28_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView miTextoNormal;
    TextView miTextoAnuncio;
    int NumVecesPulsas = 0;
    public  int NumText = 0;
    Thread miPublicidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miTextoNormal = (TextView) findViewById(R.id.miTextoNormal);
        miTextoAnuncio = (TextView) findViewById(R.id.miTextoAnuncio);
        Button miboton1 = (Button) findViewById(R.id.miBoton1);
        miboton1.setOnClickListener(this::onClick);

    }

    public void onResume(){
        super.onResume();
        miPublicidad.start();
    }
    public void onStart(){
        super.onStart();

        miPublicidad = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<100 ; i++){
                    NumText = i;
                    cambiaTexto(NumText);
                    try {
                        Thread.sleep(1500);
                    }catch (InterruptedException e ){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public  void cambiaTexto(int numText){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                miTextoAnuncio.setText("En el run " + NumText);
            }
        });
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.miBoton1:
                NumVecesPulsas++;
                miTextoNormal.setText("Pulsado " + NumVecesPulsas);
                break;
            default:
                break;
        }
    }
}