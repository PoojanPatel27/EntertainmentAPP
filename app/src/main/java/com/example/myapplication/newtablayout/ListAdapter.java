package com.example.myapplication.newtablayout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter <String> {

    Activity context;
    String[] mname;
    Integer[] mimage;


    public ListAdapter(Activity context,String[]mname, Integer[]mimage) {
        super(context,R.layout.movies_layout,mname);

        this.context = context;
        this.mname = mname;
        this.mimage = mimage;


    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.movies_layout,null,true);

        TextView textView1= rowview.findViewById(R.id.mname);
        ImageView imageView1 = rowview.findViewById(R.id.mimage);



        textView1.setText(mname[position]);
        imageView1.setImageResource(mimage[position]);



        return rowview;
    }
}
