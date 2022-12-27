package com.example.qasemtest.Aurora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.qasemtest.databinding.ActivitySplashBinding;


public class Splash extends AppCompatActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setAnimationAndHandler();
//        setDataInDataBase();
    }



    private void setAnimationAndHandler() {
        YoYo.with(Techniques.RotateInUpRight).repeat(0).duration(800).playOn(binding.tvAurora);
        YoYo.with(Techniques.RotateInUpLeft).repeat(0).duration(500).playOn(binding.tvWelcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            }
        },3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}