package com.example.beelan.interInvest.supports;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.beelan.interInvest.MyApplication;


public class UserLocalStore {

    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String LOGGED_IN = "loggedIn";

    private static SharedPreferences sharedPref;



    static{
        Context context = MyApplication.getInstance();
        sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static synchronized void setUserData(User data){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(EMAIL, data.email);
        editor.putString(PASSWORD, data.password);
        editor.commit();
    }

    public static User getUserData(){
        String userEmail = sharedPref.getString(EMAIL, null);
        String userPass  = sharedPref.getString(PASSWORD, null);

        return new User(userEmail, userPass);
    }

    public static void setUserLoggedIn(boolean state){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(LOGGED_IN, state);
        editor.commit();
    }

    public static void cleanUserData(){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.commit();
    }

    public static boolean isUserLoggedIn(){

        if(sharedPref.getBoolean(LOGGED_IN, false) == true){
            return true;
        }else {
            return false;
        }

    }

}


