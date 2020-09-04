package com.example.gads_leaderboard_mobile_application;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LeaderViewPager extends FragmentPagerAdapter {

    public LeaderViewPager(FragmentManager fm){super (fm);}

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new SkillFragment();
            default:
                return new LearningFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
