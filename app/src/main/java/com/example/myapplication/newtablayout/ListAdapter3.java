package com.example.myapplication.newtablayout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.newtablayout.R;

public class ListAdapter3 extends ArrayAdapter <String> {

    Activity context;
    String[] wsname;
    Integer[] wsimage;


    public ListAdapter3 (Activity context, String[]wsname, Integer[]wsimage) {
        super(context, R.layout.movies_layout,wsname);

        this.context = context;
        this.wsname = wsname;
        this.wsimage = wsimage;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.movies_layout,null,true);

        TextView textView3= rowview.findViewById(R.id.mname);

        ImageView imageView3= rowview.findViewById(R.id.mimage);






        textView3.setText(wsname[position]);

        imageView3.setImageResource(wsimage[position]);


        return rowview;
    }
}