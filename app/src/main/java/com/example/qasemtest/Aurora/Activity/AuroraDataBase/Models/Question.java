package com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Level.class,parentColumns = {"level_no"},childColumns = {"id_level_child"},onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)})
public class Question {
    @PrimaryKey(autoGenerate = true)
    private int question_Id;
    @NonNull
    private int id ;
    @NonNull
    private String title;
    private String answer_1;
    private String answer_2;
    private String answer_3;
    private String answer_4;
    @NonNull
    private String true_answer;
    @NonNull
    private int points;
    @NonNull
    private int duration;
    @NonNull
    private int pattern_id;
    @NonNull
    private String hint;
    @NonNull
    private int id_level_child;

    public Question() {
    }

    public Question(int id, @NonNull String title, String answer_1, String answer_2, String answer_3, String answer_4, @NonNull String true_answer, int points, int duration, int pattern_id, @NonNull String hint, int id_level_child) {
        this.id = id;
        this.title = title;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.answer_4 = answer_4;
        this.true_answer = true_answer;
        this.points = points;
        this.duration = duration;
        this.pattern_id = pattern_id;
        this.hint = hint;
        this.id_level_child = id_level_child;
    }

    public int getQuestion_Id() {
        return question_Id;
    }

    public void setQuestion_Id(int question_Id) {
        this.question_Id = question_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public String getAnswer_4() {
        return answer_4;
    }

    public void setAnswer_4(String answer_4) {
        this.answer_4 = answer_4;
    }

    @NonNull
    public String getTrue_answer() {
        return true_answer;
    }

    public void setTrue_answer(@NonNull String true_answer) {
        this.true_answer = true_answer;
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

    public int getPattern_id() {
        return pattern_id;
    }

    public void setPattern_id(int pattern_id) {
        this.pattern_id = pattern_id;
    }

    @NonNull
    public String getHint() {
        return hint;
    }

    public void setHint(@NonNull String hint) {
        this.hint = hint;
    }

    public int getId_level_child() {
        return id_level_child;
    }

    public void setId_level_child(int id_level_child) {
        this.id_level_child = id_level_child;
    }
}
