package com.example.mainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import  com.squareup.picasso.Picasso;
import com.google.firebase.database.ValueEventListener;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.net.InternetDomainName;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class tarihActivity extends AppCompatActivity {

TextView textView;
ImageView imageView;
private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
private DatabaseReference databaseReference = firebaseDatabase.getReference();
private DatabaseReference first = databaseReference.child("image");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarih);
//metin cekme
        textView = findViewById(R.id.textViewTarih);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tarih");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);

                textView.setText(m);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

//resim
        imageView = findViewById(R.id.imgf);
    }
//resim

    @Override
    protected void onStart() {
        super.onStart();
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot dataSnaphot) {


                String Link = dataSnaphot.getValue(String.class);
                Picasso.get().load(Link).into(imageView);
                

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}