package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class belge_ornek_Activity extends AppCompatActivity {

    WebView webbelgeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belge_ornek);


        baglabelge();
        yuklebelge();
        webbelgeView.setWebViewClient(new WebViewClient());

    }




    public void baglabelge(){

        webbelgeView = findViewById(R.id.belgeweb);

    }

    public void yuklebelge(){

        webbelgeView.loadUrl("https://www.karaman.bel.tr/belgeler");
        webbelgeView.getSettings().setJavaScriptEnabled(true);

    }



}