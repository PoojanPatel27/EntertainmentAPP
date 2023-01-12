package com.example.myapplication.newtablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WebseiresDetails extends AppCompatActivity {

    ImageView dimage;
    TextView dname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webseires_details);

        dimage = findViewById(R.id.dImageWeb);
        dname = findViewById(R.id.dNameWeb);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Integer image = intent.getIntExtra("image",R.drawable.stranger_things);

        dname.setText(name);
        dimage.setImageResource(image);
        
        

    }
}