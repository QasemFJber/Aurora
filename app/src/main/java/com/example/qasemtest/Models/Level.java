package com.example.qasemtest.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class Level {

    @SerializedName("level_no")
    @Expose
    @PrimaryKey
    private int levelNo;
    @SerializedName("unlock_points")
    @Expose
    @NonNull
    private int unlockPoints;
    @SerializedName("questions")
    @Expose
    @NonNull
    private List<Question> questions = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Level() {
    }

    /**
     *
     * @param unlockPoints
     * @param levelNo
     */
    public Level(int levelNo , int unlockPoints){
        this.levelNo=levelNo;
        this.unlockPoints=unlockPoints;
    }
    public Level(int levelNo, int unlockPoints, List<Question> questions) {
        super();
        this.levelNo = levelNo;
        this.unlockPoints = unlockPoints;
        this.questions = questions;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public int getUnlockPoints() {
        return unlockPoints;
    }

    public void setUnlockPoints(int unlockPoints) {
        this.unlockPoints = unlockPoints;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}