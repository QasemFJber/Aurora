package com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Level {
    @PrimaryKey
    private int level_no;
    @NonNull
    private int unlock_points;

    public Level() {
    }

    public Level(int level_no, int unlock_points) {
        this.level_no = level_no;
        this.unlock_points = unlock_points;
    }

    public int getLevel_no() {
        return level_no;
    }

    public void setLevel_no(int level_no) {
        this.level_no = level_no;
    }

    public int getUnlock_points() {
        return unlock_points;
    }

    public void setUnlock_points(int unlock_points) {
        this.unlock_points = unlock_points;
    }
}
