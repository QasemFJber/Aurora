package com.example.qasemtest.Aurora.Activity.Adapters.Level;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.Aurora.Activity.Interface.RecyclerViewListener;
import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ItemStageRecBinding;

import java.util.ArrayList;
import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder>  {
    private List<Level> levelList;
    private RecyclerViewListener listener;

    public LevelAdapter(List<Level> levelList,RecyclerViewListener listener) {
        this.levelList = levelList;
        this.listener=listener;
    }



    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStageRecBinding binding = ItemStageRecBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Level level = levelList.get(position);
        holder.binding.tvLevelNumber.setText(String.valueOf(level.getLevel_no()));
        holder.binding.tvUnloukpoints.setText(String.valueOf(level.getUnlock_points()));
        if (levelList.get(position).getLevel_no() >=1){
//            holder.binding.imagelouk.setImageDrawable(R.drawable.ic_baseline_lock_24);
        }
        holder.binding.cardlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onItemClick(levelList.get(position).getLevel_no());
            }
        });

    }



    @Override
    public int getItemCount() {
        return levelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ItemStageRecBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemStageRecBinding.bind(itemView);
        }
    }

}

