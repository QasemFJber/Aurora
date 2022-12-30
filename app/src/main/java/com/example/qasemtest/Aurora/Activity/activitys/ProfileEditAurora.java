package com.example.qasemtest.Aurora.Activity.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.qasemtest.Aurora.Activity.Profile;
import com.example.qasemtest.Aurora.Activity.SharedPreferences.AppSharedPreference;
import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ActivityProfileEditAuroraBinding;

public class ProfileEditAurora extends AppCompatActivity {

    ActivityProfileEditAuroraBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileEditAuroraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        saveDataInSharedPreference();
        binding.saveButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Profile.class);
            startActivity(intent);
        });


    }


    private void saveDataInSharedPreference() {
        String name =binding.editName.getText().toString().trim();
        String email =binding.editName.getText().toString().trim();
        String username =binding.editName.getText().toString().trim();
        String password =binding.editName.getText().toString().trim();
        AppSharedPreference.getInstance().getEditor().putString("name",name);
        AppSharedPreference.getInstance().getEditor().putString("email",email);
        AppSharedPreference.getInstance().getEditor().putString("username",username);
        AppSharedPreference.getInstance().getEditor().putInt("password", Integer.parseInt(password));
    }

}