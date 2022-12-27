package com.example.qasemtest.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Pattern {

    @SerializedName("pattern_id")
    @Expose
    @PrimaryKey
    private int patternId;
    @SerializedName("pattern_name")
    @Expose
    @NonNull
    private String patternName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pattern() {
    }

    /**
     *
     * @param patternName
     * @param patternId
     */
    public Pattern(int patternId, String patternName) {
        super();
        this.patternId = patternId;
        this.patternName = patternName;
    }

    public int getPatternId() {
        return patternId;
    }

    public void setPatternId(int patternId) {
        this.patternId = patternId;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

}