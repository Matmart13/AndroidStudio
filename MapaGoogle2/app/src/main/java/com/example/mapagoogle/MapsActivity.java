package com.example.mapagoogle;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapagoogle.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Button miBotonBarcelona;
    private  Button Ir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Ir = (Button) findViewById(R.id.posicionir);
        Ir.setOnClickListener(this);
        miBotonBarcelona = (Button) findViewById(R.id.botonposicion);
        miBotonBarcelona.setOnClickListener(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Activamos caracteristicas del mapa
        UiSettings mapSetting;
        mapSetting = mMap.getUiSettings();
        // Add a marker in Sydney and move the camera
        LatLng Aranjuez = new LatLng(40.0310800, -3.6024600);
        LatLng Madrid = new LatLng(41.24122, 2.10265);
        mMap.addMarker(new MarkerOptions().position(Aranjuez).title("Marker in Aranjuez"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Aranjuez));
        mMap.addMarker(new MarkerOptions().position(Madrid).title("Marker in Barcelona"));

        //zomm
        mapSetting.setZoomControlsEnabled(true);
        //Brujula
        mapSetting.setCompassEnabled(true);
        //Barra de herramientas del mapa
        mapSetting.setMapToolbarEnabled(true);

        //Esto es ne
        //mMap.setOnMapClickListener(this);
    }
public void onClick(View view){
        switch (view.getId()) {
            case R.id.botonposicion:
                LatLng Barcelona = new LatLng(41.24122, 2.10265);
                mMap.addMarker(new MarkerOptions().position(Barcelona).title("Barcelona")
                        .snippet("Barcelona"));
                mMap.animateCamera(CameraUpdateFactory.newLatLng(Barcelona));
                break;
            case R.id.posicionir:
                EditText campoNombre = (EditText) findViewById(R.id.texto);
                String nombreCiudad = campoNombre.getText().toString();
                if (Geocoder.isPresent()) {
                    try {
                        Geocoder gc = new Geocoder(MapsActivity.this);
                        List<Address> addresses = gc.getFromLocationName(nombreCiudad, 1);
                        List<LatLng> ll = new ArrayList<LatLng>(addresses.size());
                        for (Address a : addresses) {
                            if (a.hasLatitude() && a.hasLongitude()) {
                                ll.add(new LatLng(a.getLatitude(), a.getLongitude()));
                                LatLng nuevaPos = new LatLng(a.getLatitude(), a.getLongitude());
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(nuevaPos));
                            }
                        }

                    } catch (IOException e) {

                    }
                }
                break;
        }
    }
}