package com.example.gps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.security.acl.Permission;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationListenerCompat;
import java.security.Provider;
public class MainActivity extends AppCompatActivity implements LocationListener {
    private LocationManager locationManager;
    String proveedor;
    boolean GPSPermitido = false;
    double latitudVal;
    double longitudVal;
    String latitudTxt;
    String longitudTxt;
    TextView latitud;
    TextView longitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitud = (TextView) findViewById(R.id.miLatitud);
        longitud = (TextView) findViewById(R.id.miLongitud);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria c = new Criteria();
        proveedor = locationManager.getBestProvider(c, false);
        Toast.makeText(MainActivity.this, proveedor, Toast.LENGTH_SHORT).show();
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Comprueba si tenemos permisos para usar la GeoPosición
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[] {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 99);
        int permisoCoarseLocation = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permisoFineLocation = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permisoCoarseLocation != PackageManager.PERMISSION_GRANTED &&
                permisoFineLocation != PackageManager.PERMISSION_GRANTED){
            String mensageTxt = "No hay permisos para el GPS "+ permisoCoarseLocation +", "+ permisoFineLocation;
            Toast.makeText(getApplicationContext(), mensageTxt, Toast.LENGTH_SHORT).show() ;
        };
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Button miBotonActivaGPS = (Button) findViewById(R.id.boton_activa_gps);
        miBotonActivaGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GPSPermitido) {
//Esto lanza onLocationChanged cada vez que la posición GPS cambia
                    locationManager.requestLocationUpdates(proveedor,10,5,MainActivity.this);

                    Toast.makeText(MainActivity.this, "Buscando Posición GPS", Toast.LENGTH_SHORT).show();
                }
            }
        });
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Button miBotonDesactivaGPS = (Button) findViewById(R.id.boton_para_gps);
        miBotonDesactivaGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Detiene las llamadas a onLocationChanged por requestLocationUpdates
                locationManager.removeUpdates(MainActivity.this);
                Toast.makeText(MainActivity.this, "GPS Parado", Toast.LENGTH_SHORT).show();
            }
        });
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Button miBotonUltimaPosicionConocida = (Button) findViewById(R.id.boton_ultima_posicion_conocida);
        miBotonUltimaPosicionConocida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (locationGPS != null) {
                    Toast.makeText(MainActivity.this, "Untima Posisicón Conodida", Toast.LENGTH_SHORT).show();
                    latitudVal= locationGPS.getLatitude();

                    longitudVal = locationGPS.getLongitude();
                    latitudTxt = String.valueOf(latitudVal);
                    longitudTxt = String.valueOf(longitudVal);
                    latitud.setText(latitudTxt);
                    longitud.setText(longitudTxt);

                } else {
                    Toast.makeText(getApplicationContext(), "No encuentro localización", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //-------------------------------------------------------------------------------------------------------
//Esta función se dispara cuando cambian los permisos de uso de la GeoPosición
//-------------------------------------------------------------------------------------------------------
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 99: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permiso Otorgado", Toast.LENGTH_SHORT).show();
                        GPSPermitido = true;

                        Button btnOnGps = (Button) findViewById(R.id.boton_activa_gps);

                        btnOnGps.setEnabled(true);

                        Button btnOffGps = (Button) findViewById(R.id.boton_para_gps);

                        btnOffGps.setEnabled(true);

                        Button btnUltPos = (Button) findViewById(R.id.boton_ultima_posicion_conocida);

                        btnUltPos.setEnabled(true);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Permiso Denegado", Toast.LENGTH_SHORT).show();
                    GPSPermitido = false;
                }
                return;
            }
        }
    }
    //-------------------------------------------------------------------------------------------------------
//Se invoca cuando se completa una operación de descarga y después de que se hayan entregado las ubicaciones descargadas.
//-------------------------------------------------------------------------------------------------------
    @Override
    public void onFlushComplete(int requestCode){}
    //-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
    @Override
    public void onLocationChanged(Location location) {
        latitudVal= location.getLatitude();
        longitudVal = location.getLongitude();
        latitudTxt = String.valueOf(latitudVal);
        longitudTxt = String.valueOf(longitudVal);
        latitud.setText(latitudTxt);
        longitud.setText(longitudTxt);
    }
    //-------------------------------------------------------------------------------------------------------
//Este metodo quedó obsoleto en API 29. No será llamado en Android Q o superior
//-------------------------------------------------------------------------------------------------------
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch(status) {
            case LocationProvider.AVAILABLE:
                Toast.makeText(MainActivity.this, "GPS Disponible", Toast.LENGTH_SHORT).show();
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Toast.makeText(MainActivity.this, "Temporalment Inaccesible", Toast.LENGTH_SHORT).show();
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Toast.makeText(MainActivity.this, "Fuera de Servicio", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    //-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
    @Override
    public void onProviderEnabled(String provider) {
        proveedor = provider;
        Toast.makeText(MainActivity.this, proveedor, Toast.LENGTH_SHORT).show();
    }
    //-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
    @Override
    public void onProviderDisabled(String provider) {}
}