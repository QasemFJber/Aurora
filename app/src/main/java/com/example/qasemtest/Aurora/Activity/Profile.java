package com.example.qasemtest.Aurora.Activity;

import android.app.Dialog;
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

import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ActivityProfileBinding;

public class Profile extends AppCompatActivity{
    ActivityProfileBinding binding;
    private Dialog dialog;
    private String userName;
    private String userEmail;
    private int userPhone;
    private String userLocation;
    private SharedpreferencesAurora sharedpreferencesAurora =  new SharedpreferencesAurora();
//    static SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppController.getContext());
//    public static SharedPreferences.Editor editor = sharedPreferences.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        String name = sharedPreferences.getString("username","No Name");
//        String email = sharedPreferences.getString("useremail","No Email");
//        String phone = sharedPreferences.getString("userphone","No Phone");
//        String location = sharedPreferences.getString("userlocation","No Location");
//        if (name == null){
//            Toast.makeText(this, "Update Fialed", Toast.LENGTH_SHORT).show();
//        }else {
////            binding.tvUsername.setText(name);
//        }

//        binding.tvUseremail.setText(email);
//        binding.tvUserphone.setText(phone);
//        binding.tvUserlocation.setText(location);



        binding.textView.setOnClickListener(v -> {
            showDialog();
        });

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