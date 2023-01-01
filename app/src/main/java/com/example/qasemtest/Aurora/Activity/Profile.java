package com.example.qasemtest.Aurora.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.NumberOfQuestion;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.ViewModel;
import com.example.qasemtest.Aurora.Activity.SharedPreferences.AppSharedPreference;
import com.example.qasemtest.Aurora.Activity.activitys.ProfileEditAurora;
import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ActivityProfileBinding;

import java.util.List;

public class Profile extends AppCompatActivity {
    ActivityProfileBinding binding;
    private Dialog dialog;
    private ViewModel viewModel ;
    String password;
    String username;
    String email;
    String name;

    enum data
    {

    }    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
         name =AppSharedPreference.getInstance().getSharedPreferences().getString("name","No Name");
         email =AppSharedPreference.getInstance().getSharedPreferences().getString("email","No Email");
        username =AppSharedPreference.getInstance().getSharedPreferences().getString("username","No User Name");
         password =AppSharedPreference.getInstance().getSharedPreferences().getString("password","No Password");
       setDataInTextView();

        binding.editButton.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), ProfileEditAurora.class);
            startActivity(intent);
        });
        viewModel.getAllNumberOfQuestion().observe(this, new Observer<List<NumberOfQuestion>>() {
            @Override
            public void onChanged(List<NumberOfQuestion> numberOfQuestions) {

                binding.numberofquestions.setText(""+numberOfQuestions.size());
            }
        });
        viewModel.getAllTrueAnswer().observe(this, new Observer<List<NumberOfQuestion>>() {
            @Override
            public void onChanged(List<NumberOfQuestion> numberOfQuestions) {
                binding.correctNumber.setText(""+numberOfQuestions.size());
            }
        });
        viewModel.getAllFalseAnswer().observe(this, new Observer<List<NumberOfQuestion>>() {
            @Override
            public void onChanged(List<NumberOfQuestion> numberOfQuestions) {
                binding.worng.setText(""+numberOfQuestions.size());
            }
        });



//    private void SetDataInTextView() {
//        String name = AppSharedPreference.getInstance().getSharedPreferences().getString("name","NoNAME");
//        String email =AppSharedPreference.getInstance().getSharedPreferences().getString("email","NoEmail");
//        String username =AppSharedPreference.getInstance().getSharedPreferences().getString("username","NoUserName");
//        int pass = AppSharedPreference.getInstance().getSharedPreferences().getInt("password",0);
//        binding.titleName.setText(name);
//        binding.titleUsername.setText(username);
//        binding.profileName.setText(name);
//        binding.profileEmail.setText(email);
//        binding.profileUsername.setText(userName);
//        binding.profilePassword.setText(pass);
//    }


//    private synchronized void  showDialog() {
//
//        dialog= new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.bottomsheetlayout);
//        EditText username = dialog.findViewById(R.id.et_username);
//        EditText useremail = dialog.findViewById(R.id.et_useremail);
//        EditText userphone = dialog.findViewById(R.id.et_userphone);
//        EditText userlocation = dialog.findViewById(R.id.et_userlocation);
//        Button btn_save = dialog.findViewById(R.id.btn_Save);
//        btn_save.setOnClickListener(v -> {
//           userName = username.getText().toString().trim();
//            userEmail = useremail.getText().toString().trim();
////            userPhone = Integer.parseInt(userphone.getText().toString().trim());
//            userLocation = userlocation.getText().toString().trim();
//
////            sharedpreferencesAurora.editProfile(userName,userEmail,userPhone,userLocation);
//            dialog.dismiss();
//        });
//
//
//
//
//        dialog.show();
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog.getWindow().setGravity(Gravity.BOTTOM);
//
//    }
    }

    private void setDataInTextView() {
        binding.titleName.setText(name);
        binding.titleUsername.setText(username);
        binding.profileName.setText(name);
        binding.profileEmail.setText(email);
        binding.profileUsername.setText(username);
        binding.profilePassword.setText(password);
    }
}