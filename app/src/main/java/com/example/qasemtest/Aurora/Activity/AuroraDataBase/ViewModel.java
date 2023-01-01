package com.example.qasemtest.Aurora.Activity.AuroraDataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.NumberOfQuestion;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Question;
import com.example.qasemtest.Aurora.Activity.Interface.InsertListener;

import java.util.List;

public class ViewModel extends AndroidViewModel {
//    SONArray jsonArray = new JSONArray(readJsonData());
private Repository mRepository;




    public ViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application);

    }



    // Stage table functions
    public void insert_level(Level level,InsertListener listener) {
        mRepository.insert_level(level,listener);
    }
    public void update_level(Level level) {
        mRepository.update_level(level);
    }
    public void delete_level(Level level) {
        mRepository.delete_level(level);
    }
    public LiveData<List<Level>> getAllLevel() {
        return mRepository.getAllLevel();
    }




    // Questions table functions
    public void insert_Question(Question question, InsertListener listener) {
        mRepository.insert_Question(question, new InsertListener() {
            @Override
            public void InsertLevel(long id) {

            }
        });
    }
    public void update_Question(Question question ) {
        mRepository.update_Question(question);
    }
        public void delete_Question(Question question) {
        mRepository.delete_Question(question);
    }
    public LiveData<List<Question>> getAllQuestion() {
        return mRepository.getAllQuestions();
    }
    public LiveData<List<Question>> getAllQuestionOfLevel(int id) {
        return mRepository.getAllQuestionsOfLevel(id);
    }





    public void insert_QuestionOfNumber(NumberOfQuestion numberOfQuestion, InsertListener listener) {
        mRepository.insert_QuestionOfNumber(numberOfQuestion, new InsertListener() {
            @Override
            public void InsertLevel(long id) {
                listener.InsertLevel(id);
            }
        });
    }
    public void update_QuestionOfNumber(NumberOfQuestion numberOfQuestion ) {
        mRepository.update_QuestionOfNumber(numberOfQuestion);
    }
    public void delete_QuestionOfNumber(NumberOfQuestion numberOfQuestion) {
        mRepository.delete_QuestionOfNumber(numberOfQuestion);
    }
    public LiveData<List<NumberOfQuestion>> getAllNumberOfQuestion () {
        return mRepository.getAllQuestionOfNumber();
    }


    public LiveData<List<NumberOfQuestion>> getAllTrueAnswer() {
        return mRepository.getAllTrueAnswer();
    }

    public LiveData<List<NumberOfQuestion>> getAllFalseAnswer() {
        return mRepository.getAllFalseAnswer();
    }

}


