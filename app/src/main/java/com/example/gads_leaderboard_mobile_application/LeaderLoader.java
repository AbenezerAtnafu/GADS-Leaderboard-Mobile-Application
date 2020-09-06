package com.example.gads_leaderboard_mobile_application;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class LeaderLoader extends AsyncTaskLoader<List<Leader>> {

    private  static final String LOG_TAG =  LeaderLoader.class.getName();

    private String stringUrl;

    public LeaderLoader(Context context, String stringUrl){
        super(context);
        this.stringUrl = stringUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<Leader> loadInBackground() {
        if(stringUrl == null){
            return null;
        }

        List<Leader> leaderList = NetworkQueryUtils.fetchLeaderData(stringUrl);
        System.out.println(leaderList.get(1));
        return leaderList;
    }


}
