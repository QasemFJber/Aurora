package com.example.qasemtest.Aurora.Activity.AuroraDataBase.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Question;

import java.util.List;

@Dao
public interface Question_Dao {
    @Insert
    long insert_Question (Question question);
    @Update
    int update_Question(Question question);
    @Delete
    int delete_Question (Question question);
    @Query("select * from Question")
    LiveData<List<Question>> getAllQuestions ();
    @Query("select * from Question where id_level_child =:id")
    LiveData<List<Question>> getAllQuestionsOfLevel (int id);

}
