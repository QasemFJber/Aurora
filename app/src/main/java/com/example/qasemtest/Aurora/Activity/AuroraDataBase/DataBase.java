package com.example.qasemtest.Aurora.Activity.AuroraDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Dao.Level_Dao;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Dao.Question_Dao;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Question;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Level.class,  Question.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {



    public abstract Level_Dao level_dao();

    public abstract Question_Dao question_dao();

    private static volatile DataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DataBase.class, "aurora_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}