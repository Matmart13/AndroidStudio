package com.example.conexionconphp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView txtUrl;
    TextView txtRespuesta;
    TextView txtStatus;
    Button miBoton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUrl = findViewById(R.id.textUrl);
        txtRespuesta = findViewById(R.id.textRespuesta);
        miBoton = findViewById(R.id.miBoton);

        // Para quitar el error: adnroid.es.Network......
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


    }

    public void onClick(View view) {

        try {
            URL miUrl = new URL("http://192.168.3.173/ciudades.php?nombre=martin");
            //URL miUrl = new URL("https://gs.litterator.info/php/prueba_conexion_com_servidor.php");

            txtUrl.setText("" + miUrl.toString());

            HttpURLConnection miHtp = (HttpURLConnection) miUrl.openConnection();
            miHtp.setRequestMethod("GET");
            InputStream miEntrada = miHtp.getInputStream();
            InputStreamReader miLector = new InputStreamReader(miEntrada);
            BufferedReader miBufferLector = new BufferedReader(miLector);
            String Linea = miBufferLector.readLine();
            txtRespuesta.setText(Linea);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}