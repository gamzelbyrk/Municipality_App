package com.example.mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /*binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());*/

        findViewById(R.id.alisveris_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,alisveris_kategoriler_Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.sehir_rehberi_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,sehir_rehberi_kategoriler_Activitiy.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.kultur_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,kultur_activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.e_belediye_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,e_belediye_activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.guncel_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,guncel_activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.belediye_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,belediye_activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.ulasim_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,ulasim_activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.oneri_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,oneri_activity.class);
                startActivity(intent);
            }
        });


    }


}
