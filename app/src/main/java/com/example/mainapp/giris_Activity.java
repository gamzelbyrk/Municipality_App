package com.example.mainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.*;
import androidx.core.content.ContextCompat;
import static androidx.biometric.BiometricManager.Authenticators.*;

public class giris_Activity extends AppCompatActivity {
    Button btn_fppin;
    private EditText editEmail, editSifre;
    private String txtEmail, txtSifre;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
//parmak izi
        btn_fppin=findViewById(R.id.btn_fppin);
        checkBioMetricSupported();
        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(giris_Activity.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                        "Hata " + errString, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "Giriş Başarılı!" , Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();

                Toast.makeText(getApplicationContext(), "Giriş Başarısız",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
        btn_fppin.setOnClickListener(view -> {
            BiometricPrompt.PromptInfo.Builder promptInfo = dialogMetric();
            promptInfo.setDeviceCredentialAllowed(true);
            biometricPrompt.authenticate(promptInfo.build());
        });
        editEmail=findViewById(R.id.girisemail);
        editSifre=findViewById(R.id.girissifre);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.heabimyoktext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(giris_Activity.this,kayit_Activity.class);
                startActivity(intent);
            }
        });

    }

//Parmak izi
    BiometricPrompt.PromptInfo.Builder dialogMetric()
    {
        //Show prompt dialog
        return new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biyometrik giriş")
                .setSubtitle("Biyometrik kimlik bilgilerinizi kullanarak giriş yapın");
    }


    void checkBioMetricSupported()
    {
        BiometricManager manager = BiometricManager.from(this);
        String info="";
        switch (manager.canAuthenticate(BIOMETRIC_WEAK | BIOMETRIC_STRONG))
        {
            case BiometricManager.BIOMETRIC_SUCCESS:
                info = "Doğru";
                enableButton(true);
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                info = "Bu Özellik Bu Cihazda Kullanılamaz";
                enableButton(false);
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                info = "Biyometrik Veriler Kullanılamayacak Durumda";
                enableButton(false);
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                info = "En Az Bir Parmak İzi Kaydetmeniz Gerekiyor";
                enableButton(false,true);
                break;
            default:
                info= "Bilinmeyen";
                enableButton(false);
        }

    }
    void enableButton(boolean enable)
    {
        btn_fppin.setEnabled(true);
    }
    void enableButton(boolean enable,boolean enroll)
    {
        enableButton(enable);

        if(!enroll) return;

        final Intent enrollIntent = new Intent(Settings.ACTION_BIOMETRIC_ENROLL);
        enrollIntent.putExtra(Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                BIOMETRIC_STRONG | DEVICE_CREDENTIAL);
        startActivity(enrollIntent);
    }
//Normal Giriş
    public void GirisYap(View view){

        txtEmail = editEmail.getText().toString();
        txtSifre = editSifre.getText().toString();

        if(!TextUtils.isEmpty(txtEmail)&&!TextUtils.isEmpty(txtSifre)){


            mAuth.signInWithEmailAndPassword(txtEmail,txtSifre)
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            mUser = mAuth.getCurrentUser();

                            System.out.println("Kullanıcı Adı:" +mUser.getDisplayName());
                            System.out.println("Kullanıcı e-Mail:" +mUser.getEmail());
                            System.out.println("Kullanıcı Uid:" +mUser.getUid());
                            finish();
                            startActivity(new Intent(giris_Activity.this, e_belediye_islemler_Activity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                        }
                    }).addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {

                    Toast.makeText(giris_Activity.this, e.getMessage(),Toast.LENGTH_SHORT).show();

                }
            });

        }else
            Toast.makeText(this,"e-Mail ve  Şifre Alanı Boş Olamaz", Toast.LENGTH_SHORT).show();

    }
}