package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class kultur_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kultur);

        findViewById(R.id.tarih_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kultur_activity.this, tarihActivity.class);
                startActivity(intent);


            }
        });
        findViewById(R.id.yoresel_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kultur_activity.this, yoreselActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.muze_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kultur_activity.this, muzeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.foto_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kultur_activity.this, fotoActivity.class);
                startActivity(intent);
            }
        });

    }
}