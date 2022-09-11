package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sehir_rehberi_kategoriler_Activitiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sehir_rehberi_kategoriler_activitiy);





        findViewById(R.id.kent_rehberi_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(sehir_rehberi_kategoriler_Activitiy.this,sehir_rehberi_activity.class);
                startActivity(intent);
            }
        });




        findViewById(R.id.nobetci_eczaneler_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sehir_rehberi_kategoriler_Activitiy.this, nobetci_eczane_Activity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.belge_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sehir_rehberi_kategoriler_Activitiy.this, belge_ornek_Activity.class);
                startActivity(intent);
            }
        });



    }
}