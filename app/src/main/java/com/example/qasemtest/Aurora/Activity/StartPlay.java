package com.example.qasemtest.Aurora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.qasemtest.Aurora.Activity.Adapters.pagerAdapter.PagerAdapter;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.NumberOfQuestion;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Question;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.ViewModel;
import com.example.qasemtest.Aurora.Activity.Fradment.PlayFragment;
import com.example.qasemtest.Aurora.Activity.Interface.InsertListener;
import com.example.qasemtest.Aurora.Activity.Interface.ListenerAnswer;
import com.example.qasemtest.databinding.ActivityStartPlayBinding;

import java.util.ArrayList;
import java.util.List;

public class StartPlay extends AppCompatActivity implements ListenerAnswer {

    ActivityStartPlayBinding binding;
    private ViewModel viewModel ;
    private List<Fragment> fragmentList = new ArrayList<>();
    private PagerAdapter pagerAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Aurora Game ");
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        Intent intent = getIntent();
        int position = intent.getIntExtra("pos",1);
        Log.e("ID_LEVEL","Level"+position);

        pagerAdapter = new PagerAdapter(this,fragmentList);
        viewModel.getAllQuestionOfLevel(position).observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                for (int i = 0; i <questions.size(); i++) {
                    Log.e("QASEM_LIST","List"+questions.size());
                    fragmentList.add(PlayFragment.newInstance(questions.get(i)));
                }
                Log.e("QUESTION_LIST","LIST"+questions.size());
            }
        });
//        Log.e("QASEM_LIST","QASEM"+fragmentList.size());
        binding.pager.setAdapter(pagerAdapter);


    }

    @Override
    public void OnTrueAnswer(int id) {
        binding.pager.setUserInputEnabled(false);
        binding.pager.setCurrentItem(binding.pager.getCurrentItem()+1);
        NumberOfQuestion numberOfQuestion = new NumberOfQuestion(id,22);
        viewModel.insert_QuestionOfNumber(numberOfQuestion, new InsertListener() {
            @Override
            public void InsertLevel(long id) {

            }
        });
    }

    @Override
    public void OnFalseAnswer(int id) {
        binding.pager.setUserInputEnabled(false);
        binding.pager.setCurrentItem(binding.pager.getCurrentItem()+1);
        NumberOfQuestion numberOfQuestion = new NumberOfQuestion(id,33);
        viewModel.insert_QuestionOfNumber(numberOfQuestion, new InsertListener() {
            @Override
            public void InsertLevel(long id) {

            }
        });
    }



}