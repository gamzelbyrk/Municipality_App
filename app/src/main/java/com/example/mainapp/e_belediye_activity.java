package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class e_belediye_activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebelediye);


        findViewById(R.id.firstgirisbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(e_belediye_activity.this,giris_Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.firstkayitbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(e_belediye_activity.this,kayit_Activity.class);
                startActivity(intent);
            }
        });

    }
}