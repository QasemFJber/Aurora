package com.example.qasemtest.Aurora.Activity.AuroraDataBase.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Level;
import com.example.qasemtest.Aurora.Activity.Interface.CallBackList;
import com.example.qasemtest.Aurora.Activity.Interface.InsertListener;

import java.util.List;

@Dao
public interface Level_Dao {
    @Insert
    long insert_Level (Level level);
    @Update
    int update_Level (Level level);
    @Delete
    int delete_Level (Level level);
    @Query("select * from Level")
    LiveData<List<Level>> getAllLevels ();

}
