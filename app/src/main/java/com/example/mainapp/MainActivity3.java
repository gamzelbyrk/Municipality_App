package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;


    Button arabasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(homeIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);


    }
}