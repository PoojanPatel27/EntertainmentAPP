package com.example.myapplication.newtablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    ImageView dimage;
    TextView dname;
    Button dbtn;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        dimage = findViewById(R.id.dimage);
        dname = findViewById(R.id.dname);
        dbtn = findViewById(R.id.dbtn);



        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Integer image = intent.getIntExtra("image",R.drawable.kgf);
        String link = intent.getStringExtra("link");

        dname.setText(name);
        dimage.setImageResource(image);




        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent1);
            }
        });



    }
}