package com.example.qasemtest.Aurora.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qasemtest.databinding.ActivityStartPlayBinding;

public class StartPlay extends AppCompatActivity {

    ActivityStartPlayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}