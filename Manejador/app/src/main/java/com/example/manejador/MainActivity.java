package com.example.manejador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(MainActivity.this, "Recibo un " + msg.what, Toast.LENGTH_SHORT).show();
                if(msg.what == 0){

                }
                if (msg.what == 1) {

                } else {

                }
            }
        };
}

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                handler.sendEmptyMessage(0);
                break;
            case R.id.button2:
                handler.sendEmptyMessage(1);
                break;
        }
    }
}