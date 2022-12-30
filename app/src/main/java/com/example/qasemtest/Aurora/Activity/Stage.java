package com.example.qasemtest.Aurora.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.qasemtest.Aurora.Activity.Adapters.Level.LevelAdapter;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.ViewModel;
import com.example.qasemtest.databinding.ActivityLevelBinding;

import java.util.ArrayList;
import java.util.List;

public class Stage extends AppCompatActivity {

    private ActivityLevelBinding binding;
    private LevelAdapter adapter = new LevelAdapter(new ArrayList<>(),this);
    private List<Level> levelList = new ArrayList<>();
    private ViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setDataInRecycler();
    }


    private void setDataInRecycler() {
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllLevel().observe(this, new Observer<List<Level>>() {
            @Override
            public void onChanged(List<Level> levels) {
                adapter.setLevelList(levels);
                binding.rvLevel.setAdapter(adapter);
                binding.rvLevel.setHasFixedSize(true);
                binding.rvLevel.setLayoutManager(new LinearLayoutManager(Stage.this));
            }
        });

    }

}