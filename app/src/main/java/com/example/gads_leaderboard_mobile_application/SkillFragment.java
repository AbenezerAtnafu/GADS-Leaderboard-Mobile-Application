package com.example.gads_leaderboard_mobile_application;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class SkillFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Leader>> {

    public SkillFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    private List<Leader> leaders = new ArrayList<>();
    private static final String SKILL_REQUEST_URL =
            "https://gadsapi.herokuapp.com/api/skilliq";

    private Uri baseUri;
    Uri.Builder baseUriBuilder;
    static LeaderListAdapter leaderListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View leaderRootView = inflater.inflate(R.layout.fragment_learning, container, false);

        recyclerView = leaderRootView.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setAdapter(leaderListAdapter);

        recyclerView.setLayoutManager(layoutManager);

        return leaderRootView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        baseUri = Uri.parse(SKILL_REQUEST_URL);
        baseUriBuilder = baseUri.buildUpon();



//        leaders.add(new Leader("Abene",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));
//        leaders.add(new Leader("abuchu",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));
//        leaders.add(new Leader("ete",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));
//        leaders.add(new Leader("eco",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));
//        leaders.add(new Leader("akvakv",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));


    }

    @Override
    public Loader<List<Leader>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URLxxx
        return new LeaderLoader(getContext(), baseUriBuilder.toString());
    }
//
    @Override
    public void onLoadFinished(Loader<List<Leader>> loader, List<Leader> data) {
        if (data != null && !data.isEmpty()) {
            this.leaderListAdapter = new LeaderListAdapter(getContext(), data);

            System.out.println(leaders.get(1).getName());

           // mProgressBar.setVisibility(View.GONE);
            Log.d(SkillFragment.class.getSimpleName(), data.toString());
        }
        else{
            leaderListAdapter = new LeaderListAdapter(getContext(), leaders);
            recyclerView.setAdapter(leaderListAdapter);
        }
    }
//
    @Override
    public void onLoaderReset(Loader<List<Leader>> loader) {

    }
//
//
    @Override
    public void onStop() {
        super.onStop();

    }


}
