package com.example.assighment2;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;




public class PreferenceUtils {
    private static final String PREF_NAME = "MyPreferences";
    private static final String KEY_USER = "user";

    private SharedPreferences preferences;
    private Gson gson;

    public PreferenceUtils(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveUser(User user) {
        String userJson = gson.toJson(user);
        preferences.edit().putString(KEY_USER, userJson).apply();
    }

    public User getUser() {
        String userJson = preferences.getString(KEY_USER, null);
        if (userJson != null) {
            return gson.fromJson(userJson, User.class);
        }
        return null;
    }



}
