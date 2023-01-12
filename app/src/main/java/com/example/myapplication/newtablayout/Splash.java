package com.example.myapplication.newtablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottieAnimationView = findViewById(R.id.lottieAnimationView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             Intent intent = new Intent(getApplicationContext(),Login.class);
             startActivity(intent);
             finish();
            }
        },2500);
    }

}