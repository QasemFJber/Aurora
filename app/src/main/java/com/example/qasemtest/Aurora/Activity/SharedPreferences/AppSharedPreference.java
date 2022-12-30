package com.example.qasemtest.Aurora.Activity.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.qasemtest.Aurora.Activity.controllers.AppController;

public class AppSharedPreference {

    private static AppSharedPreference instance;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;



    private AppSharedPreference(){
        preferences = AppController.getInstance().getSharedPreferences("prefs_puzzle", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }


    public static AppSharedPreference getInstance(){
        if (instance == null){
            instance = new AppSharedPreference();
        }
        return instance;
    }




    public SharedPreferences.Editor getEditor(){
        return editor;
    }

    public SharedPreferences getSharedPreferences(){
        return preferences;
    }


//    SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor;
//    private static AppSharedPreferences instance;
//
//    public static AppSharedPreferences getInstance() {
//        return instance;
//    }
//
//    public SharedPreferences getSharedPreferences() {
//        return sharedPreferences;
//    }
//
//    public SharedPreferences.Editor getEditor() {
//        return editor;
//    }
//
//    public AppSharedPreferences(Context context) {
//        sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
//    }
//
//
//    public static AppSharedPreferences getInstance(Context context) {
//        if (instance == null) {
//            instance = new AppSharedPreferences(context);
//        }
//        return instance;
//    }
//
//
//    public void clear() {
//        editor = sharedPreferences.edit();
//        editor.clear();
//        editor.apply();
//    }
}
