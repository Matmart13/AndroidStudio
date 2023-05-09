package com.example.manejador2;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button miButton = (Button) findViewById(R.id.button);
        miButton.setOnClickListener(this);

        Button miButton2 = (Button) findViewById(R.id.button2);
        miButton2.setOnClickListener(this);
        Button miButton3 = (Button) findViewById(R.id.cambiapantalla);
        miButton3.setOnClickListener(this);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle bundle = msg.getData();
                Toast.makeText(MainActivity.this,""+ bundle.get("CLAVE1"), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,""+ bundle.get("CLAVE2"), Toast.LENGTH_SHORT).show();

                TextView miTextView = (TextView) findViewById(R.id.miTextoAnuncios);
                miTextView.setText(""+bundle.get("CLAVE1"));
            }
        };
    }




    public void onClick(View view) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        switch (view.getId()){
            case R.id.button:
                bundle.putString("CLAVE1","VALOR 1");
                bundle.putString("CLAVE2", "Valor de la clave 2");
                message.setData(bundle);

                handler.sendMessageDelayed(message,3000);
                break;
            case R.id.button2:
                bundle.putString("CLAVE1","VALOR 1");
                bundle.putString("CLAVE2", "Valor de la clave 2");
                message.setData(bundle);

                handler.sendMessageDelayed(message,1000);
                break;
            case R.id.cambiapantalla:
                Intent cambiaPantalla = new Intent(this,Actividad.class);
                startActivity(cambiaPantalla);
                Actividad actividad = new Actividad();
                Actividad.MiHandler handlerActividad2 = actividad.new MiHandler();
                bundle.putString("Clave3","Valor de Clave 3 para actividad");
                message.setData(bundle);
                handlerActividad2.sendMessageDelayed(message,2000);
            default:
                break;
        }
    }
}

