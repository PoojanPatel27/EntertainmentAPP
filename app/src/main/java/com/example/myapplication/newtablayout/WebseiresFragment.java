package com.example.myapplication.newtablayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;


public class WebseiresFragment extends Fragment {

    String[] wsnames = {"Stranger Things","Squid Game","Money Heist","Locke & Key","Mirzapur","Kota Factory","Scam 1992","Lucifer"};
    Integer[] wsimages = {R.drawable.stranger_things,R.drawable.squid_game,R.drawable.money_heist,R.drawable.locke_key,R.drawable.mirzapur,
            R.drawable.kota_factory,R.drawable.scam1992,R.drawable.lucifer};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_webseires, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listview3;

        listview3 = getView().findViewById(R.id.listview3);

        ListAdapter3 listAdapter3 = new ListAdapter3(getActivity(),wsnames,wsimages);
        listview3.setAdapter(listAdapter3);

        listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(),WebseiresDetails.class);

                intent.putExtra("name",wsnames[position]);
                intent.putExtra("image",wsimages[position]);
                startActivity(intent);

            }
        });





    }
}