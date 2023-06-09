package com.example.abrircamara;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int CAMERA_ACTION_CODE = 1;
    private ImageView imageProfile;
    private  static  final int Image_Capture_Code = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageProfile = findViewById(R.id.imageView);
    }
    protected void onStart(){
        super.onStart();
        Button miBotonJava = (Button) findViewById(R.id.button);
        miBotonJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager())!= null){
                    startActivityForResult(intent,CAMERA_ACTION_CODE); ;
                }else{
                    Toast.makeText(MainActivity.this,"La app no soporta esta accion", Toast.LENGTH_LONG);

                }
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == CAMERA_ACTION_CODE && resultCode == RESULT_OK && data != null){
            Bundle bundle = data.getExtras();
            Bitmap finalPhoto = (Bitmap) bundle.get("data");
            imageProfile.setImageBitmap(finalPhoto);
        }
    }
}