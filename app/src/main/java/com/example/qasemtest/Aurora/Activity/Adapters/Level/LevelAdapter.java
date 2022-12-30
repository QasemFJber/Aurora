package com.example.qasemtest.Aurora.Activity.Adapters.Level;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.databinding.ItemStageRecBinding;

import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder>  {
    private List<Level> levelList;
    private Context context;

    public LevelAdapter(List<Level> levelList, Context context) {
        this.levelList = levelList;
        this.context = context;
    }

    public List<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
//        notifyItemRangeInserted(0,levelList.size());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStageRecBinding binding = ItemStageRecBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Level level = levelList.get(position);
        holder.binding.tvLevelNumber.setText(level.getLevel_no());
        holder.binding.tvUnloukpoints.setText(level.getUnlock_points());

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

