package com.example.myapplication.newtablayout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.newtablayout.R;

public class ListAdapter2 extends ArrayAdapter <String> {

    Activity context;
    String[] muname;
    Integer[] muimage;


    public ListAdapter2(Activity context, String[]muname, Integer[]muimage) {
        super(context, R.layout.movies_layout,muname);

        this.context = context;
        this.muname = muname;
        this.muimage = muimage;


    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.movies_layout,null,true);

        TextView textView2= rowview.findViewById(R.id.mname);

        ImageView imageView2= rowview.findViewById(R.id.mimage);






        textView2.setText(muname[position]);

        imageView2.setImageResource(muimage[position]);


        return rowview;
    }
}