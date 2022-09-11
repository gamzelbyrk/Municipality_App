package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class alisveris_kategoriler_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alisveris_kategoriler);

        findViewById(R.id.pazar_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(alisveris_kategoriler_Activity.this,pazar_Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.toptan_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(alisveris_kategoriler_Activity.this,toptanci_Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.avm_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(alisveris_kategoriler_Activity.this,avm_konum_Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.cafe_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(alisveris_kategoriler_Activity.this,kafeler_konum_Activity.class);
                startActivity(intent);
            }
        });


    }
}