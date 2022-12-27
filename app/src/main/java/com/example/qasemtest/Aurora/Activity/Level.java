package com.example.qasemtest.Aurora.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qasemtest.databinding.ActivityLevelBinding;

public class Level extends AppCompatActivity {
    ActivityLevelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}