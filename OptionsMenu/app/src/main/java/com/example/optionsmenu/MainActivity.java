package com.example.optionsmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu Menu){
    getMenuInflater().inflate(R.menu.opciones_menu,Menu);
    return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem Item) {
        TextView miTexto = (TextView) findViewById(R.id.miTexto);
        switch (Item.getItemId()) {
            case R.id.opcion1:
                miTexto.setText("Selecionada Opcion A");
                return  true;
            case R.id.opcion2:
                miTexto.setText("Selecionada Opcion B");
                return  true;
            case R.id.MnOP2_1:
                miTexto.setText("Selecionado Opcion B.1");
                return  true;
            case R.id.MnOP2_2:
                miTexto.setText("Selecionado Opcion B.2");
                return true;
            case R.id.opcion3:
                miTexto.setText("Selecionada Opcion C");
                return  true;

            default:
                return super.onOptionsItemSelected(Item);
        }
    }
}