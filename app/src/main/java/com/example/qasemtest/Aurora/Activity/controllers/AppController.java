package com.example.qasemtest.Aurora.Activity.controllers;

import android.app.Application;
import android.content.Context;

public class AppController extends Application {
    private  static AppController instance ;


    public static AppController getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }



       //    private static String readJsonData() {
//
//        String jsonDataString = "";
//
//        try (InputStream inputStream = AppController.getContext().getAssets().open("puzzleGameData.json");) {
//            int size = inputStream.available();
//            byte[] byteArray = new byte[size];
//            inputStream.read(byteArray);
//            inputStream.close();
//
//            jsonDataString = new String(byteArray, StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return jsonDataString;
//    }
//
//
//    private List<Level> getLeve(){
//        List<Level> levelList=new ArrayList<>();
//        try {
//            JSONArray jsonArray=new JSONArray(readJsonData());
//            for (int i = 0; i < jsonArray.length(); i++) {
//
//                String id=jsonArray.getJSONObject(i).getString("Qasem");
//                int point=jsonArray.getJSONObject(i).getInt("");
//                Log.d("TAG", "getLeve: "+id);
//
//                Level level=new Level();
//                levelList.add(level);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return levelList;
//    }


}

