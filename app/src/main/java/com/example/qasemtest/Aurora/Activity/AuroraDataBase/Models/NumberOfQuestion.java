package com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NumberOfQuestion {
    @PrimaryKey(autoGenerate = true)
    private int id_data;
    @NonNull
    private int id_questions ;
    @NonNull
    private int trueOrFalseAAnswer;

    public NumberOfQuestion() {
    }

    public NumberOfQuestion(int id_questions, int trueOrFalseAAnswer) {
        this.id_questions = id_questions;
        this.trueOrFalseAAnswer = trueOrFalseAAnswer;
    }

    public int getId_data() {
        return id_data;
    }

    public void setId_data(int id_data) {
        this.id_data = id_data;
    }

    public int getId_questions() {
        return id_questions;
    }

    public void setId_questions(int id_questions) {
        this.id_questions = id_questions;
    }

    public int getTrueOrFalseAAnswer() {
        return trueOrFalseAAnswer;
    }

    public void setTrueOrFalseAAnswer(int trueOrFalseAAnswer) {
        this.trueOrFalseAAnswer = trueOrFalseAAnswer;
    }
}
