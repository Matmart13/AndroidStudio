package com.example.dialogosynotificaciones;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int variable;
    CharSequence[] elementos = {"1", "2", "3", "4", "5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu Menu) {
        getMenuInflater().inflate(R.menu.opcionesmenu, Menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem Item) {
        TextView miTexto = (TextView) findViewById(R.id.miTexto);
        switch (Item.getItemId()) {
            case R.id.opcion1:
                Toast toast = Toast.makeText(getApplicationContext(), "Mensaje de Simple", Toast.LENGTH_SHORT);
                //Toast toast = Toast.makeText(getApplicationContext(), "Mensaje de Toast", 1000);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                miTexto.setText("Selecionada Opcion 1");
                return true;
            case R.id.opcion2:
                miTexto.setText("Selecionada Opcion 2");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Hola buenas tardes").setTitle("TÍTULO ").setIcon(R.mipmap.ic_launcher).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        miTexto.setText("Pulsaste ok");
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        miTexto.setText("Pulsaste no ");
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        miTexto.setText("Pulsaste Cancel");
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            case R.id.opcion3:

                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle("TITULO").setItems(elementos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        i = i + 1;
                        miTexto.setText("Seleccionado " + i);
                    }
                });
                AlertDialog dialog3 = builder3.create();
                dialog3.show();
                miTexto.setText("Selecionado Opcion 3");
                return true;
            case R.id.opcion4:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setTitle("Selección").setSingleChoiceItems(elementos, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        i = i + 1;
                        miTexto.setText("Seleccionado " + (int) i);
                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        miTexto.setText("Pulsaste oK");
                    }
                });
                AlertDialog dialog4 = builder4.show();
                dialog4.show();
                miTexto.setText("Selecionado Opcion 4");
                return true;
            case R.id.opcion5:

                miTexto.setText("Selecionada Opcion 5");
                return true;

            default:
                return super.onOptionsItemSelected(Item);
        }
    }
}