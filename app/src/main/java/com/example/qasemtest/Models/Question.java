package com.example.qasemtest.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.regex.Pattern;

@Entity
public class Question {

    @PrimaryKey
    private int id_database;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    @NonNull
    private String title;
    @SerializedName("answer_1")
    @Expose
    @NonNull
    private String answer1;
    @SerializedName("answer_2")
    @Expose
    @NonNull
    private String answer2;
    @SerializedName("answer_3")
    @Expose
    @NonNull
    private String answer3;
    @SerializedName("answer_4")
    @Expose
    @NonNull
    private String answer4;
    @SerializedName("true_answer")
    @Expose
    @NonNull
    private String trueAnswer;
    @SerializedName("points")
    @Expose
    @NonNull
    private int points;
    @SerializedName("duration")
    @Expose
    private int duration;
    @SerializedName("pattern")
    @Expose
    private Pattern pattern;
    @SerializedName("hint")
    @Expose
    private String hint;

    /**
     * No args constructor for use in serialization
     *
     */
    public Question() {
    }

    /**
     *
     * @param duration
     * @param trueAnswer
     * @param hint
     * @param answer3
     * @param pattern
     * @param answer2
     * @param id
     * @param answer4
     * @param title
     * @param answer1
     * @param points
     */
    public Question(int id_database,int id, String title, String answer1, String answer2, String answer3, String answer4, String trueAnswer, int points, int duration, Pattern pattern, String hint) {
        super();
        this.id_database=id_database;
        this.id = id;
        this.title = title;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.trueAnswer = trueAnswer;
        this.points = points;
        this.duration = duration;
        this.pattern = pattern;
        this.hint = hint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

}