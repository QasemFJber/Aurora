package com.example.qasemtest.Aurora.Activity.Adapters.Questions;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Question;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolderQuestion> {
    private List<Question> list;

    public QuestionsAdapter(List<Question> list) {
        this.list = list;
    }

    public void setList(List<Question> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderQuestion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderQuestion holder, int position) {
        Question question = list.get(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderQuestion extends RecyclerView.ViewHolder{
        public ViewHolderQuestion(@NonNull View itemView) {
            super(itemView);
        }
    }
}
