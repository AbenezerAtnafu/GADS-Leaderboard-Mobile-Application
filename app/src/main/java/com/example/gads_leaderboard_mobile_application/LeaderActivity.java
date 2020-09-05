package com.example.gads_leaderboard_mobile_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class LeaderActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private LeaderViewPager leaderViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        leaderViewPager = new LeaderViewPager(getSupportFragmentManager());

        leaderViewPager.addFragment(new LearningFragment(), "Learning Leader");
        leaderViewPager.addFragment(new SkillFragment(), "Skill Leader");

        viewPager.setAdapter(leaderViewPager);

        tabLayout.setupWithViewPager(viewPager);
    }
}
