/*package com.example.mainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class kayit_Activity extends AppCompatActivity {
    private EditText editEmail, editSifre;
    private String txtEmail, txtSifre;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);


        editEmail=findViewById(R.id.kayitemail);
        editSifre=findViewById(R.id.kayitsifre);
        mAuth = FirebaseAuth.getInstance();


       /* findViewById(R.id.KayıtOl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(kayit_Activity.this,e_belediye_islemler_Activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.heabimvartext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(kayit_Activity.this,giris_Activity.class);
                startActivity(intent);
            }
        });



    }

    public void KayitOl (View view){

        txtEmail = editEmail.getText().toString();
        txtSifre = editSifre.getText().toString();

        if(!TextUtils.isEmpty(txtEmail)&&!TextUtils.isEmpty(txtSifre)){


            mAuth.createUserWithEmailAndPassword(txtEmail,txtSifre)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                                Toast.makeText(kayit_Activity.this, "Kayıt İşlemi Başarılı", Toast.LENGTH_SHORT).show();

                            else
                                Toast.makeText(kayit_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(kayit_Activity.this, e_belediye_islemler_Activity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                        }
                    });


        }else
            Toast.makeText(this,"e-Mail ve  Şifre Alanı Boş Olamaz", Toast.LENGTH_SHORT).show();
    }



}*/
package com.example.mainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;

public class kayit_Activity extends AppCompatActivity {
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference referans=storage.getReference();
    private EditText editEmail, editSifre;
    private String txtEmail, txtSifre;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private HashMap<String, Object> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        findViewById(R.id.heabimvartext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(kayit_Activity.this,giris_Activity.class);
                startActivity(intent);
            }
        });
        editEmail=findViewById(R.id.kayitemail);
        editSifre=findViewById(R.id.kayitsifre);
        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();
    }
    public void KayitOl(View view) {

        txtEmail = editEmail.getText().toString();
        txtSifre = editSifre.getText().toString();

        if (!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre)) {

            mAuth.createUserWithEmailAndPassword(txtEmail,txtSifre)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                mUser=mAuth.getCurrentUser();
                                mData= new HashMap<>();
                                mData.put("KullaniciUid", mUser.getUid());
                                mData.put("Kullanicimail:", txtEmail);
                                mData.put("KullaniciSifre:", txtSifre);

                                mReference.child("Users").child(mUser.getUid())
                                        .setValue(mData)
                                        .addOnCompleteListener(kayit_Activity.this, new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful())
                                                    Toast.makeText(kayit_Activity.this,"Kayıt Bşarılı!", Toast.LENGTH_SHORT).show();
                                                else
                                                    Toast.makeText(kayit_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }

                            else
                                Toast.makeText(kayit_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(kayit_Activity.this, e_belediye_islemler_Activity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                        }
                    });

        }else
            Toast.makeText(this,"e-Mail veya Şifre Alanı Boş!", Toast.LENGTH_SHORT).show();
    }
}