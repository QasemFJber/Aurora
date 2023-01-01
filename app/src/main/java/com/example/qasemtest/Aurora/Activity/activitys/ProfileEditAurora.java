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
        binding.saveButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Profile.class);
            Bundle bundle = new Bundle();
            String name =binding.editName.getText().toString().trim();
            String email =binding.editEmail.getText().toString().trim();
            String username =binding.editUsername.getText().toString().trim();
            String password =binding.editPassword.getText().toString().trim();
            AppSharedPreference.getInstance().getEditor().putString("name",name).commit();
            AppSharedPreference.getInstance().getEditor().putString("email",email).commit();
            AppSharedPreference.getInstance().getEditor().putString("username",username).commit();
            AppSharedPreference.getInstance().getEditor().putString("password",password).commit();
//            bundle.putString("name",name);
//            bundle.putString("email",email);
//            bundle.putString("username",username);
//            bundle.putString("password", password);
//            intent.putExtras(bundle);
            startActivity(intent);
//            AppSharedPreference.getInstance().getEditor().putBoolean("editprof",true).commit();
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}