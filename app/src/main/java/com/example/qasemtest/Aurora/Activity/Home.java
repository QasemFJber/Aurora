package com.example.qasemtest.Aurora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity implements View.OnClickListener {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       setonClick();
       setAnimatoin();
        }

    private void setAnimatoin() {
        YoYo.with(Techniques.Wobble).repeat(0).duration(2000).playOn(binding.logo);
        YoYo.with(Techniques.RotateIn).repeat(0).duration(2000).playOn(binding.btnStartPlay);
        YoYo.with(Techniques.RotateInUpLeft).repeat(0).duration(2000).playOn(binding.settings);
        YoYo.with(Techniques.RotateInUpRight).repeat(0).duration(2000).playOn(binding.logout);
    }

    private void setonClick(){
        binding.btnStartPlay.setOnClickListener(this::onClick);
        binding.settings.setOnClickListener(this::onClick);
        binding.logout.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
       if (view.getId() == R.id.btn_start_play){
           Intent intent = new Intent(getApplicationContext(), Stage.class);
           startActivity(intent);

       }else if (view.getId() == R.id.settings){
           Intent intent = new Intent(getApplicationContext(),Settings.class);
           startActivity(intent);

       }else if (view.getId() == R.id.logout){
           finish();
       }

    }
}