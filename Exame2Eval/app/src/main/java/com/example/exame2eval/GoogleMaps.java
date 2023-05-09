package com.example.exame2eval;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.fragment.app.FragmentActivity;

import com.example.exame2eval.databinding.ActivityMapagoogleBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapagoogleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMapagoogleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        UiSettings mapSetting;
        mapSetting = mMap.getUiSettings();

        String nombreDir= getIntent().getStringExtra("nombre");
        double lat= Double.parseDouble(getIntent().getStringExtra("lat"));
        double lon= Double.parseDouble(getIntent().getStringExtra("lon"));

        LatLng dir = new LatLng(lat,lon);
        mMap.setMinZoomPreference(5);
        mapSetting.setZoomControlsEnabled(true);
        mMap.addMarker(new MarkerOptions().position(dir).title("Marker in "+nombreDir));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dir));
        mapSetting.setZoomControlsEnabled(true);

    }
}