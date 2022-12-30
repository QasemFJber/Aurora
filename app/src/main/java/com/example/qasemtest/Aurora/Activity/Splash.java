package com.example.qasemtest.Aurora.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Question;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.ViewModel;
import com.example.qasemtest.Aurora.Activity.Interface.InsertListener;
import com.example.qasemtest.Aurora.Activity.ProfileWithFirebase.SignupActivity;
import com.example.qasemtest.Aurora.Activity.SharedPreferences.AppSharedPreference;
import com.example.qasemtest.Aurora.Activity.controllers.AppController;
import com.example.qasemtest.databinding.ActivitySplashBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class Splash extends AppCompatActivity {
    ActivitySplashBinding binding;
    ViewModel viewModel ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setAnimationAndHandler();
        viewModel=new ViewModelProvider(this).get(ViewModel.class );
        insertOneTime();


    }

    private void LoadDataToDataBase() {
        insertDataOfLevel();
        insertDataOfQuestion();
    }


    private void setAnimationAndHandler() {
        YoYo.with(Techniques.RotateInUpRight).repeat(0).duration(800).playOn(binding.tvAurora);
        YoYo.with(Techniques.RotateInUpLeft).repeat(0).duration(500).playOn(binding.tvWelcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        }, 3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }



    private void insertOneTime(){
        boolean result = AppSharedPreference.getInstance().getSharedPreferences().getBoolean("storage",false);
        if (result){

        }else {
            LoadDataToDataBase();
            AppSharedPreference.getInstance().getEditor().putBoolean("storage",true).apply();
        }
    }

    public String loadJsonFromAssets(){
        String json =null;
        try {
            try(InputStream inputStream = AppController.getInstance().getAssets().open("puzzleGameData.json")) {
                int size= inputStream.available();
                byte[] bytes = new byte[size];
                inputStream.read(bytes);
                inputStream.close();
                json = new String(bytes, StandardCharsets.UTF_8);
            }

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }


    public List<Level> getLevel() {
        List<Level> levelList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(loadJsonFromAssets());

            for (int i = 0; i < jsonArray.length(); i++) {

                int idStage = jsonArray.getJSONObject(i).getInt("level_no");
                int points = jsonArray.getJSONObject(i).getInt("unlock_points");
                Level stages = new Level(idStage, points);
                levelList.add(stages);


            }
        } catch (JSONException e) {
            //e.printStackTrace();

        }
        return levelList;
    }


    private  void insertDataOfLevel(){
        for (int i = 0; i <getLevel().size() ; i++) {
            viewModel.insert_level(getLevel().get(i), new InsertListener() {
                @Override
                public void InsertLevel(long id) {
                }
            });
        }
    }

    private  void insertDataOfQuestion(){
        for (int i = 0; i <getQuestionsJson().size() ; i++) {
            viewModel.insert_Question(getQuestionsJson().get(i), new InsertListener() {
                @Override
                public void InsertLevel(long id) {
                }
            });
        }
    }


    public List<Question> getQuestionsJson(){
        List<Question> questionsList =new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(loadJsonFromAssets());
            for (int a = 0; a < jsonArray.length(); a++) {
                int id_Level = jsonArray.getJSONObject(a).getInt("level_no");
                JSONArray jA=jsonArray.getJSONObject(a).getJSONArray("questions");
                for (int i = 0; i < jA.length(); i++) {

                    int id_puzzle = jA.getJSONObject(i).getInt("id");
                    String text_puzzle = jA.getJSONObject(i).getString("title");
                    String first_answer = jA.getJSONObject(i).getString("answer_1");
                    String second_answer = jA.getJSONObject(i).getString("answer_2");
                    String third_answer = jA.getJSONObject(i).getString("answer_3");
                    String fourth_answer = jA.getJSONObject(i).getString("answer_4");
                    String correct_answer = jA.getJSONObject(i).getString("true_answer");
                    int points = jA.getJSONObject(i).getInt("points");
                    int duration = jA.getJSONObject(i).getInt("duration");
                    int pattern_Id = jA.getJSONObject(i).getJSONObject("pattern").getInt("pattern_id");
                    String hint = jA.getJSONObject(i).getString("hint");

//                    int id, @NonNull String title, String answer_1, String answer_2, String answer_3, String answer_4, @NonNull String true_answer, int points, int duration, int pattern_id, @NonNull String hint
                    Question question = new Question(id_puzzle, text_puzzle, first_answer, second_answer, third_answer, fourth_answer, correct_answer, points, duration, pattern_Id, hint,id_Level);
                    questionsList.add(question);

                }
            }
        }catch (JSONException e){
            //e.printStackTrace();
        }
        return questionsList;
    }

}




