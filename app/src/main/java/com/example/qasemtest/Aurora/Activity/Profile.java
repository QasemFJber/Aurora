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

import com.example.qasemtest.Aurora.Activity.SharedPreferences.AppSharedPreference;
import com.example.qasemtest.Aurora.Activity.activitys.ProfileEditAurora;
import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ActivityProfileBinding;

public class Profile extends AppCompatActivity{
    ActivityProfileBinding binding;
    private Dialog dialog;
    private String userName;
    private String userEmail;
    private int userPhone;
    private String userLocation;

//    static SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppController.getContext());
//    public static SharedPreferences.Editor editor = sharedPreferences.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SetDataInTextView();
        binding.editButton.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), ProfileEditAurora.class);
            startActivity(intent);
        });



//        binding.b.setOnClickListener(v -> {
//            showDialog();
//        });

    }

    private void SetDataInTextView() {
        String name = AppSharedPreference.getInstance().getSharedPreferences().getString("name","NoNAME");
        String email =AppSharedPreference.getInstance().getSharedPreferences().getString("email","NoEmail");
        String username =AppSharedPreference.getInstance().getSharedPreferences().getString("username","NoUserName");
        int pass = AppSharedPreference.getInstance().getSharedPreferences().getInt("password",0);
        binding.titleName.setText(name);
        binding.titleUsername.setText(username);
        binding.profileName.setText(name);
        binding.profileEmail.setText(email);
        binding.profileUsername.setText(userName);
        binding.profilePassword.setText(pass);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profilemenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.update){
            Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    private synchronized void  showDialog() {

        dialog= new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);
        EditText username = dialog.findViewById(R.id.et_username);
        EditText useremail = dialog.findViewById(R.id.et_useremail);
        EditText userphone = dialog.findViewById(R.id.et_userphone);
        EditText userlocation = dialog.findViewById(R.id.et_userlocation);
        Button btn_save = dialog.findViewById(R.id.btn_Save);
        btn_save.setOnClickListener(v -> {
           userName = username.getText().toString().trim();
            userEmail = useremail.getText().toString().trim();
//            userPhone = Integer.parseInt(userphone.getText().toString().trim());
            userLocation = userlocation.getText().toString().trim();

//            sharedpreferencesAurora.editProfile(userName,userEmail,userPhone,userLocation);
            dialog.dismiss();
        });




        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}