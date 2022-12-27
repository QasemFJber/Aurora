package com.example.qasemtest.Aurora.Activity.controllers;

import android.content.Context;
import android.util.Log;

import com.example.qasemtest.Models.Level;
import com.example.qasemtest.Models.Pattern;
import com.example.qasemtest.Models.Question;

import java.io.IOException;
import java.io.InputStream;

public class AuroraControllers {
    public static Level getLevel(Context context){
        try {
            InputStream inputStream = context.getAssets().open("puzzleGameData");
            Log.e("Json File","Gson"+inputStream);
            byte[] dataLevel = new byte[inputStream.available()];
            inputStream.read();
            String jsonData = new String(dataLevel,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    return new Level();
    }
    public static Question getQuestion(Context context){
        try {
            InputStream inputStream = context.getAssets().open("puzzleGameData");
            Log.e("Json File","Gson"+inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return new Question();
    }
    public static Pattern getPattern(Context context){
        try {
            InputStream inputStream = context.getAssets().open("puzzleGameData");
            Log.e("Json File","Gson"+inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Pattern();
    }
//    private static String readJsonData() {
//
//        String jsonDataString = "";
//
//        try {
//            try (InputStream inputStream = AppController.getContext().getAssets().open("puzzleGameData.json");) {
//                int size = inputStream.available();
//                byte[] byteArray = new byte[size];
//                inputStream.read(byteArray);
//                inputStream.close();
//
//                jsonDataString = new String(byteArray, StandardCharsets.UTF_8);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//        return jsonDataString;
//    }
}
