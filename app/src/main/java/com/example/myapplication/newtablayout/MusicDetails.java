package com.example.myapplication.newtablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MusicDetails extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_details);

        Intent intent = getIntent();
        String link = intent.getStringExtra("link");

        webview = findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(link);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}