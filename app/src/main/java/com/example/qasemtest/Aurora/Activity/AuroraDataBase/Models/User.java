package com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int user_Phone;
    @NonNull
    private String user_Name;
    @NonNull
    private String user_Email;
    @NonNull
    private String user_Location;

    public User(int user_Phone, @NonNull String user_Name, @NonNull String user_Email, @NonNull String user_Location) {
        this.user_Phone = user_Phone;
        this.user_Name = user_Name;
        this.user_Email = user_Email;
        this.user_Location = user_Location;
    }

    public User() {
    }

    public int getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Phone(int user_Phone) {
        this.user_Phone = user_Phone;
    }

    @NonNull
    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(@NonNull String user_Name) {
        this.user_Name = user_Name;
    }

    @NonNull
    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(@NonNull String user_Email) {
        this.user_Email = user_Email;
    }

    @NonNull
    public String getUser_Location() {
        return user_Location;
    }

    public void setUser_Location(@NonNull String user_Location) {
        this.user_Location = user_Location;
    }
}
