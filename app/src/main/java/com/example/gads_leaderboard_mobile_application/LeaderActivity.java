package com.example.gads_leaderboard_mobile_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class LeaderActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);

        ViewPager viewPager = findViewById(R.id.view_pager);

        LeaderViewPager leaderViewPager = new LeaderViewPager(getSupportFragmentManager());
        viewPager.setAdapter(leaderViewPager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
