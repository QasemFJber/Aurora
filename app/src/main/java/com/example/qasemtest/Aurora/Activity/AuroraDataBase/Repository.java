package com.example.qasemtest.Aurora.Activity.AuroraDataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Dao.Level_Dao;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Dao.Question_Dao;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Dao.User_Dao;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Question;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.User;
import com.example.qasemtest.Aurora.Activity.Interface.CallBackList;
import com.example.qasemtest.Aurora.Activity.Interface.InsertListener;

import java.util.List;

public class Repository {

    private Level_Dao level_dao;
    private Question_Dao question_dao;
    private User_Dao user_dao;

    public Repository(Application application) {
        DataBase db = DataBase.getDatabase(application);
        level_dao = db.level_dao();
        question_dao = db.question_dao();


    }






    /**
     *Stage table functions
     * Add
     * Amendment
     * deletion
     * Bring all the data into the table
     * */

    void insert_level(Level level, InsertListener listener) {
        DataBase.databaseWriteExecutor.execute(() -> {
            long id = level_dao.insert_Level(level);
            listener.InsertLevel(id);
        });
        }
    void update_level(Level level) {
        DataBase.databaseWriteExecutor.execute(() -> {
            level_dao.update_Level(level);
        });
    }
    void delete_level(Level level) {
        DataBase.databaseWriteExecutor.execute(() -> {
            level_dao.delete_Level(level);
        });
    }
    LiveData<List<Level>> getAllLevel() {
        return getAllLevel();
    }


    /**
     *Questions  table functions
     * Add
     * Amendment
     * deletion
     * Bring all the data into the table
     * */

    void insert_Question(Question question, InsertListener listener) {
        DataBase.databaseWriteExecutor.execute(() -> {
            long _id = question_dao.insert_Question(question);
            listener.InsertLevel(_id);
        });
    }
    void update_Question(Question question) {
        DataBase.databaseWriteExecutor.execute(() -> {
            question_dao.update_Question(question);
        });
    }
    void delete_Question(Question question) {
        DataBase.databaseWriteExecutor.execute(() -> {
            question_dao.delete_Question(question);
        });
    }
    LiveData<List<Question>> getAllQuestions() {
        return getAllQuestions();
    }



    /**
     *User  table functions
     * Add
     * Amendment
     * deletion
     * Bring all the data into the table
     * */


    void insert_User(User user) {
        DataBase.databaseWriteExecutor.execute(() -> {
            user_dao.insert_User(user);
        });
    }
    void update_User(User user) {
        DataBase.databaseWriteExecutor.execute(() -> {
            user_dao.update_User(user);
        });
    }
    void delete_User(User user) {
        DataBase.databaseWriteExecutor.execute(() -> {
            user_dao.delete_User(user);
        });
    }
    LiveData<List<User>> getUser() {
        return getUser();
    }


}

