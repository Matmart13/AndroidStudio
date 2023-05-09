package com.example.plantilla1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mitexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mitexto = (TextView)findViewById(R.id.Nombre) ;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu Menu) {
        getMenuInflater().inflate(R.menu.opciones_menu, Menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem Item) {

        switch (Item.getItemId()) {
            case R.id.opcion1:
                Intent i = new Intent(this, Ventana1.class);
                i.putExtra("texto",mitexto.getText().toString());
                startActivity(i);
                return true;
            case R.id.opcion3:


                return true;
        }
      return super.onOptionsItemSelected(Item);
    }
}