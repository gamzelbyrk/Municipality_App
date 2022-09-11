package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class nobetci_eczane_Activity extends AppCompatActivity {

    WebView webnobView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nobetci_eczane);


        bagl();
        yukl();
        webnobView.setWebViewClient(new WebViewClient());

    }


    public void bagl(){

        webnobView = findViewById(R.id.nobetcieczaneweb);

    }

    public void yukl(){

        webnobView.loadUrl("https://www.karamaneo.org.tr/nobet-listesi");
        webnobView.getSettings().setJavaScriptEnabled(true);

    }



}