package com.example.mainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class ulasim_activity extends AppCompatActivity {

    //veritabanından resim çekme
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    ImageView imageViewbirno;
    ImageView imageViewbirano;
    ImageView imageViewikino;
    ImageView imageViewucno;
    ImageView imageViewucano;
    ImageView imageViewdortno;
    ImageView imageViewbesno;
    ImageView imageViewaltino;
    ImageView imageViewyedino;
    ImageView imageViewsekizno;
    ImageView imageViewdokuzno;
    ImageView imageViewonno;

    private DatabaseReference first = databaseReference.child("bus_station");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasim);
        //veritabanından resim çekme

        imageViewbirno = findViewById(R.id.birnoimgview);
        imageViewbirano = findViewById(R.id.biranoimgview);
        imageViewikino = findViewById(R.id.ikinoimgview);
        imageViewucno = findViewById(R.id.ucnoimgview);
        imageViewucano = findViewById(R.id.ucanoimgview);
        imageViewdortno = findViewById(R.id.dortnoimgview);
        imageViewbesno = findViewById(R.id.besnoimgview);
        imageViewaltino = findViewById(R.id.altinoimgview);
        imageViewyedino = findViewById(R.id.yedinoimgview);
        imageViewsekizno = findViewById(R.id.sekiznoimgview);
        imageViewdokuzno = findViewById(R.id.dokuznoimgview);
        imageViewonno = findViewById(R.id.onnoimgview);

//Buttona tıkladığında saatleri göster
        Button birnobutton = findViewById(R.id.birnobutton);
        birnobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(

                        ulasim_activity.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.bottom_sheet_bir_nolu_otobus,
                                (RelativeLayout) findViewById(R.id.bottom_sheet_container_birnoluhat)
                        );

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

    }
    //veritabanından resim çekme
    @Override
    protected void onStart() {
        super.onStart();
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot dataSnaphot) {

                String Link = dataSnaphot.getValue(String.class);
                Picasso.get().load(Link).into(imageViewbirno);
                Picasso.get().load(Link).into(imageViewbirano);
                Picasso.get().load(Link).into(imageViewikino);
                Picasso.get().load(Link).into(imageViewucno);
                Picasso.get().load(Link).into(imageViewucano);
                Picasso.get().load(Link).into(imageViewdortno);
                Picasso.get().load(Link).into(imageViewbesno);
                Picasso.get().load(Link).into(imageViewaltino);
                Picasso.get().load(Link).into(imageViewyedino);
                Picasso.get().load(Link).into(imageViewsekizno);
                Picasso.get().load(Link).into(imageViewdokuzno);
                Picasso.get().load(Link).into(imageViewonno);

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }











}