package com.example.myapplication.newtablayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MoviesFragment extends Fragment {

    String[] name = {"K.G.F","Avatar:The Way Of Water","Brahmastra","M.S.Dhoni","Bhool Bhulaiya 2","Avenger End Game","Infinity War","Iron-Man","Phir Hera Pheri","Pushpa : The Rise",};
    Integer [] poster = {R.drawable.kgf,R.drawable.avatar,R.drawable.brahmastra,R.drawable.dhoni,R.drawable.bhool_bhoolaiya_2,
            R.drawable.avenger_endgame,R.drawable.infinity_war,R.drawable.ironman,R.drawable.phir_hera_pheri,R.drawable.pushpa};
    String[] links ={"https://www.youtube.com/watch?v=JKa05nyUmuQ","https://youtu.be/d9MyW72ELq0","https://www.youtube.com/watch?v=V5jVntRVl-0",
                    "https://www.youtube.com/watch?v=6L6XqWoS8tw","https://www.youtube.com/watch?v=P2KRKxAb2ek","https://www.youtube.com/watch?v=TcMBFSGVi1c","https://www.youtube.com/watch?v=6ZfuNTqbHE8",
                    "https://www.youtube.com/watch?v=8ugaeA-nMTc","https://www.youtube.com/watch?v=TmxYlA26Jr4","https://www.youtube.com/watch?v=pKctjlxbFDQ"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btn;
        ListView listView1;
        final InterstitialAd[] mInterstitialAd = new InterstitialAd[1];

        listView1 = getView().findViewById(R.id.listview1);

        ListAdapter listAdapter = new ListAdapter(getActivity(),name,poster);
        listView1.setAdapter(listAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final InterstitialAd[] mInterstitialAd = {null};

                Intent intent = new Intent(getActivity(),MovieDetails.class);

                intent.putExtra("image",poster[position]);
                intent.putExtra("name",name[position]);
                intent.putExtra("link",links[position]);
                startActivity(intent);
            }
        });

        MobileAds.initialize(getContext());

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(getContext(), "ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.e("Error",loadAdError.toString());
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);

            mInterstitialAd[0] = interstitialAd;

            mInterstitialAd[0].setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                }

                @Override
                public void onAdImpression() {
                    super.onAdImpression();
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent();

                    mInterstitialAd[0] = null;

                }
            });

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mInterstitialAd[0]!= null)
                            mInterstitialAd[0].show(getActivity());
                        else
                            Log.e("AD Pending","Ad is not ready yet!");
                    }
                },10000);


            }
        });


    }
}