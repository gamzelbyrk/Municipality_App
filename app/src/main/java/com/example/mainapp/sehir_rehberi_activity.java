package com.example.mainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class sehir_rehberi_activity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();


    ImageView imageViewbarcin;
    ImageView imageViewermenek;
    ImageView imageViewbaraj;
    ImageView imageViewincesu;
    ImageView imageViewkaramankalesi;
    ImageView imageViewkugulupark;
    ImageView imageViewyenidunya;
    ImageView imageViewgokce;

    private DatabaseReference first = databaseReference.child("place");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sehir_rehberi);



        imageViewbarcin = findViewById(R.id.barcinimg);
        imageViewermenek = findViewById(R.id.ermenekvadirsm);
        imageViewbaraj = findViewById(R.id.ermenekbarajrsm);
        imageViewincesu = findViewById(R.id.incesuimg);
        imageViewkaramankalesi = findViewById(R.id.karamankalesiimg);
        imageViewkugulupark = findViewById(R.id.kuguluparkimg);
        imageViewyenidunya = findViewById(R.id.yenidunyaimg);
        imageViewgokce = findViewById(R.id.gokceimg);


        findViewById(R.id.barcinbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sehir_rehberi_activity.this, harita_activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.ermenebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sehir_rehberi_activity.this, ermenek_vadisi_Activity.class);
                startActivity(intent);
            }
        });
        


    }


    @Override
    protected void onStart() {
        super.onStart();
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot dataSnaphot) {

                String Link = dataSnaphot.getValue(String.class);
                Picasso.get().load(Link).into(imageViewbarcin);
                Picasso.get().load(Link).into(imageViewermenek);
                Picasso.get().load(Link).into(imageViewbaraj);
                Picasso.get().load(Link).into(imageViewincesu);
                Picasso.get().load(Link).into(imageViewkaramankalesi);
                Picasso.get().load(Link).into(imageViewkugulupark);
                Picasso.get().load(Link).into(imageViewyenidunya);
                Picasso.get().load(Link).into(imageViewgokce);

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }






}