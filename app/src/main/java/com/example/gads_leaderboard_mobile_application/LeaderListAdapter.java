package com.example.gads_leaderboard_mobile_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;



public class LeaderListAdapter extends RecyclerView.Adapter<LeaderListAdapter.LeaderViewHolder> {

    private ArrayList<Leader> leaderList;
    private int numberItems;

    public LeaderListAdapter(ArrayList<Leader> leaderList){
        this.leaderList = leaderList;
    }


    @NonNull
    @Override
    public LeaderListAdapter.LeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layoutIdForLeaderListItem = R.layout.leader_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForLeaderListItem, parent, shouldAttachToParentImmediately);
        LeaderViewHolder leaderViewHolder = new LeaderViewHolder(view);

        return leaderViewHolder;
    }

    @Override
        public void onBindViewHolder(@NonNull LeaderListAdapter.LeaderViewHolder holder, int position) {
            holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class LeaderViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTextView;
        public TextView infoTextView;
        public ImageView badgeView;

        public LeaderViewHolder(View itemView){
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            infoTextView = (TextView) itemView.findViewById(R.id.info_text_view);
            badgeView = (ImageView) itemView.findViewById(R.id.badge_view);
        }

        public void bindView(int position){
            nameTextView.setText(leaderList.get(position).getName());
            infoTextView.setText(leaderList.get(position).getHours());
        }

    }

}
