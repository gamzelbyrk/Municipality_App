package com.example.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class guncel_activity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncel);
        bagla();
        yukle();
        webView.setWebViewClient(new WebViewClient());
    }

    public void bagla(){
        webView = findViewById(R.id.guncelweb);

    }

    public void yukle(){

        webView.loadUrl("https://www.karaman.bel.tr/haberler");
        webView.getSettings().setJavaScriptEnabled(true);

    }

}

//https://www.karamandan.com/