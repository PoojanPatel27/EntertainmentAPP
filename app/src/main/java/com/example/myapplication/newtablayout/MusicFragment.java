package com.example.myapplication.newtablayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class MusicFragment extends Fragment {

    String []muname={"Spotify","Youtube Music","Wynk","Resso","Hungama","Ganna","Amazone Music","Jio Savan"};
    Integer []muimages={R.drawable.spotify,R.drawable.yt_music,R.drawable.wynk,R.drawable.resso,R.drawable.hungama,
            R.drawable.gaana,R.drawable.amazone_music,R.drawable.jio_savan};
    String []links={"https://open.spotify.com/","https://music.youtube.com/","https://wynk.in/music","https://www.resso.com/in/",
            "https://www.hungama.com/","https://gaana.com/","https://www.amazon.com/music","https://www.jiosaavn.com/"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listview2;

        listview2 = getView().findViewById(R.id.listview2);

        ListAdapter2 listAdapter2 = new ListAdapter2(getActivity(),muname,muimages);
        listview2.setAdapter(listAdapter2);

        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(),MusicDetails.class);
                intent.putExtra("link",links[position]);
                startActivity(intent);

            }
        });





    }
}