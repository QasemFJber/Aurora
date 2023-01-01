package com.example.qasemtest.Aurora.Activity.controllers;

import com.example.qasemtest.Aurora.Activity.SharedPreferences.AppSharedPreference;
import com.example.qasemtest.R;

public class SoundController {
    private void setSoundInSharedPreference() {
        AppSharedPreference.getInstance().getEditor().putInt("collectcoin", R.raw.collectcoin);
        AppSharedPreference.getInstance().getEditor().putInt("levelwin", R.raw.levelwin);
        AppSharedPreference.getInstance().getEditor().putInt("notification", R.raw.notification);
        AppSharedPreference.getInstance().getEditor().putInt("success", R.raw.success);
        AppSharedPreference.getInstance().getEditor().putInt("winfantasia", R.raw.winfantasia);
    }



}
