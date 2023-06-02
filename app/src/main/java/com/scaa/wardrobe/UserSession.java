package com.scaa.wardrobe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserSession {
    private SharedPreferences sharedPreferences;

    public UserSession(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setUsername(String username){
        sharedPreferences.edit().putString("username", username).commit();
    }

    public String getUsername(){
        String username = sharedPreferences.getString("username", "");
        return username;
    }

    public void logoutUser(){
        sharedPreferences.edit().remove(getUsername());
    }

}
