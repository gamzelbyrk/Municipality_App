package com.example.mainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class yoreselActivity extends AppCompatActivity {


    Button arabasi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        setContentView(R.layout.activity_yoresel);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_yoresel);
        arabasi = (Button) findViewById(R.id.arabasibutton);
        arabasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), popactivity.class);
                startActivity(i);
            }
        });


        Button batirikbutton = findViewById(R.id.batirikbutton);
        batirikbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(

                        yoreselActivity.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.activity_layout_bottom_sheet,
                                (RelativeLayout) findViewById(R.id.bottom_sheet_container_batirik)
                        );

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });


    }

}