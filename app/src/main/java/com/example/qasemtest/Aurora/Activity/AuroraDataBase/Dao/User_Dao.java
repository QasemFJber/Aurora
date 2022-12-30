package com.example.qasemtest.Aurora.Activity.AuroraDataBase.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.User;

import java.util.List;
@Dao
public interface User_Dao {
    @Insert
    long insert_User (User user);
    @Update
    int update_User(User user);
    @Delete
    int delete_User (User user);
    @Query("select * from User")
    LiveData<List<User>> getAllUsers ();
}
