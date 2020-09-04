package com.example.gads_leaderboard_mobile_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;



public class LeaderListAdapter extends RecyclerView.Adapter<LeaderListAdapter.LeaderViewHolder> {

    private LinkedList<Leaders> leadersList;

    @NonNull
    @Override
    public LeaderListAdapter.LeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leader_list_item, parent, false);

        return new LeaderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderListAdapter.LeaderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class LeaderViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTextView;
        public TextView infoTextView;
        public ImageView badgeView;

        public LeaderViewHolder(View itemView, LeaderListAdapter leaderListAdapter){

            super(itemView);
        }

    }

}
