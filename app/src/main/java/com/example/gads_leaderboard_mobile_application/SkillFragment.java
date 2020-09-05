package com.example.gads_leaderboard_mobile_application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class SkillFragment extends Fragment {

    public SkillFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View leaderRootView = inflater.inflate(R.layout.fragment_skill, container, false);

//        recyclerView = leaderRootView.findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final ArrayList<Leader> leaders = new ArrayList<>();
        leaders.add(new Leader("Abene",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));
        leaders.add(new Leader("abuchu",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));
        leaders.add(new Leader("ete",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));
        leaders.add(new Leader("eco",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));
        leaders.add(new Leader("akvakv",20, "Ethiopia", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"));

        //recyclerView.setAdapter(new LeaderListAdapter(leaders));

        return leaderRootView;

    }


}
