package com.example.qasemtest.Aurora.Activity.AuroraDataBase.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.NumberOfQuestion;

import java.util.List;

@Dao
public interface NumberOfQuestion_Dao {
    @Insert
    long insert_QuestionOfNumber (NumberOfQuestion numberOfQuestion);
    @Update
    int update_QuestionOfNumber (NumberOfQuestion numberOfQuestion);
    @Delete
    int delete_QuestionOfNumber (NumberOfQuestion numberOfQuestion);
    @Query("select * from NumberOfQuestion")
    LiveData<List<NumberOfQuestion>> getAllQuestionOfNumber ();
    @Query("select * from NumberOfQuestion Where trueOrFalseAAnswer = 22 ")
    LiveData<List<NumberOfQuestion>> getAllTrueAnswer();
    @Query("select * from NumberOfQuestion Where trueOrFalseAAnswer = 33 ")
    LiveData<List<NumberOfQuestion>> getAllFalseAnswer();
}
