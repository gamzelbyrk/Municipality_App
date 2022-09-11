package com.example.mainapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.example.mainapp.databinding.ActivityOneriBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class oneri_activity extends AppCompatActivity {

    private DatabaseReference mReference;
    private FirebaseUser mUser;
    private HashMap<String, Object> mData;
    ActivityOneriBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;
    EditText oneriText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneri);
        oneriText = (EditText)findViewById(R.id.oneritext);


    }
    public void kydt(View view) {
        mReference = FirebaseDatabase.getInstance().getReference();
        mReference.child("ONERI").setValue(oneriText.getText().toString());
    }

}
