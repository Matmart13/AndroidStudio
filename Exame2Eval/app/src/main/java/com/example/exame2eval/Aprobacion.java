package com.example.exame2eval;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Aprobacion extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.botonesmaps);
        Intent mapa= new Intent(this, GoogleMaps.class);
        try {
            URL miUrl = new URL("http://192.168.3.173/ciudades.php?nombre=martin");
            HttpURLConnection miHtp = (HttpURLConnection) miUrl.openConnection();
            miHtp.setRequestMethod("GET");
            InputStream miEntrada = miHtp.getInputStream();
            InputStreamReader miLector = new InputStreamReader(miEntrada);
            BufferedReader miBufferLector = new BufferedReader(miLector);
            String Linea = miBufferLector.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String msg1="Cuenca&40.07653762&-2.13152306";
        String msg2="Palma de Mallorca&39.56939&2.65024";
        String msg3="Palencia&42.0078373&-4.53460106";
        String msg4 = "Pontevedra&42.43381442&-8.64799018";
        String[] primera= msg1.split("&");
        String[] segunda= msg2.split("&");
        String[] tercera= msg3.split("&");
        String[] cuarto = msg4.split("&");



        Button boton1= findViewById(R.id.dir);
        Button boton2= findViewById(R.id.dir1);
        Button boton3= findViewById(R.id.dir2);
        Button boton4 = findViewById(R.id.dir3);

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapa.putExtra("nombre",primera[0]);
                mapa.putExtra("lat",primera[1]);
                mapa.putExtra("lon",primera[2]);
                builder.setMessage("¿Seguro que quiere abrir el mapa?").setTitle("MAPA GOOGLE").setIcon(R.mipmap.ic_launcher).
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivity(mapa);
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Aprobacion.this, "HAS PULSADO NO", Toast.LENGTH_SHORT).show();
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



        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapa.putExtra("nombre",segunda[0]);
                mapa.putExtra("lat",segunda[1]);
                mapa.putExtra("lon",segunda[2]);
                builder.setMessage("¿Seguro que quiere abrir el mapa?").setTitle("MAPA GOOGLE").setIcon(R.mipmap.ic_launcher).
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivity(mapa);
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Aprobacion.this, "HAS PULSADO NO", Toast.LENGTH_SHORT).show();
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



        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapa.putExtra("nombre",tercera[0]);
                mapa.putExtra("lat",tercera[1]);
                mapa.putExtra("lon",tercera[2]);
                builder.setMessage("¿Seguro que quiere abrir el mapa?").setTitle("MAPA GOOGLE").setIcon(R.mipmap.ic_launcher).
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivity(mapa);
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Aprobacion.this, "HAS PULSADO NO", Toast.LENGTH_SHORT).show();
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

    boton4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mapa.putExtra("nombre",cuarto[0]);
            mapa.putExtra("lat",cuarto[1]);
            mapa.putExtra("lon",cuarto[2]);
            builder.setMessage("¿Seguro que quiere abrir el mapa?").setTitle("MAPA GOOGLE").setIcon(R.mipmap.ic_launcher).
                    setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivity(mapa);
                        }
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(Aprobacion.this, "HAS PULSADO NO", Toast.LENGTH_SHORT).show();
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
