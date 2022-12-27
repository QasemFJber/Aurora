package com.example.qasemtest.Aurora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ActivitySettingsBinding;

public class Settings extends AppCompatActivity implements View.OnClickListener {
    ActivitySettingsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setonclickListiner();


    }

    private void setonclickListiner() {
      binding.imageProfile.setOnClickListener(this::onClick);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.image_profile){
            Intent intent = new Intent(getApplicationContext(),Profile.class);
            startActivity(intent);
        }

    }
}