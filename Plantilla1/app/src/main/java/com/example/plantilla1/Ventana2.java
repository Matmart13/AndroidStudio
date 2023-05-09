package com.example.plantilla1;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Ventana2 extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    GoogleMap mMap;
    Double latitud,longitud;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu Menu) {
        getMenuInflater().inflate(R.menu.opcionesmenu1, Menu);
        return true;
    }
    */

    public void onMapReady(GoogleMap googleMap) {
         mMap = googleMap;
        //Activamos caracteristicas del mapa
        UiSettings mapSetting;
        mapSetting = mMap.getUiSettings();
        //
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            longitud = extras.getDouble("Longitud");
            latitud = extras.getDouble("Latitud");
        }
        LatLng ubicacion = new LatLng(latitud,longitud);


        //zomm
        mapSetting.setZoomControlsEnabled(true);
        //Brujula
        mapSetting.setCompassEnabled(true);
        //Barra de herramientas del mapa
        mapSetting.setMapToolbarEnabled(true);

        //Esto es ne
        //mMap.setOnMapClickListener(this);
        googleMap.setOnMarkerClickListener(this);
    }
 /*
    @Override

    public boolean onOptionsItemSelected(MenuItem Item) {

        switch (Item.getItemId()) {
            case R.id.opcion1:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.opcion3:


                return true;
        }
        return super.onOptionsItemSelected(Item);
    }
    */


    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        return false;
    }
}
